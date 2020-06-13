package com.chess.enigine.piece;

import com.chess.enigine.Alliance;
import com.chess.enigine.board.Board;
import com.chess.enigine.board.BoardUtils;
import com.chess.enigine.board.Move;
import com.chess.enigine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static com.chess.enigine.board.Move.*;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-17,-15,-10,-6,6,10,15,17};

    public Knight(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateMoves(final Board board) {
        List<Move> legalMoves = new ArrayList<>();
        int candidateDestinationCoordinate;
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE) {
            candidateDestinationCoordinate = this.piecePosition+currentCandidateOffset;
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                if (isFirstColumnException(this.piecePosition,currentCandidateOffset) ||
                isSecondColumnException(this.piecePosition,currentCandidateOffset) ||
                isSeventhColumnException(this.piecePosition,currentCandidateOffset) ||
                isEighthColumnException(this.piecePosition,currentCandidateOffset))
                {continue;}
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if(!candidateDestinationTile.isOccupied()){
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAtDestinationAlliance = pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance != pieceAtDestinationAlliance){
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate,
                                pieceAtDestination));
                    }
                }

            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
    private static boolean isFirstColumnException(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 ||
                candidateOffset == 6 || candidateOffset == 15);
    }
    private static boolean isSecondColumnException(final int currentPosition, final int candidateOffset){
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
    }
    private static boolean isSeventhColumnException(final int currentPosition, final int candidateOffset){
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }
    private static boolean isEighthColumnException(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 ||
                candidateOffset == 10 || candidateOffset == 17);
    }

}
