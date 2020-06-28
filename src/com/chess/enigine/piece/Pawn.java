package com.chess.enigine.piece;

import com.chess.enigine.Alliance;
import com.chess.enigine.board.Board;
import com.chess.enigine.board.BoardUtils;
import com.chess.enigine.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.chess.enigine.board.Move.*;

public class Pawn extends Piece{
    private final int[] CANDIDATE_MOVE_COORDINATE = {7 , 8 , 9 , 16 };
    public Pawn(final int piecePosition,final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE) {
            final int candidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * currentCandidateOffset);
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){continue;}
            else{
                if (currentCandidateOffset == 8 &&
                        !board.getTile(candidateDestinationCoordinate).isOccupied()){
                    legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                }
                else if (currentCandidateOffset == 16 && this.isFirstMove() &&
                        (BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceAlliance.   isBlack() ||
                        BoardUtils.SEVENTH_ROW[this.piecePosition] && this.pieceAlliance.isWhite())){
                    final int behindCandidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * 8);
                    if (!board.getTile(behindCandidateDestinationCoordinate).isOccupied() &&
                        !board.getTile(candidateDestinationCoordinate).isOccupied()) {
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }
                else if (currentCandidateOffset == 7 && !(BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()||
                        BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())) {
                    if (!board.getTile(candidateDestinationCoordinate).isOccupied()){
                        final Piece pieceAtPosition = board.getTile(candidateDestinationCoordinate).getPiece();
                        if (this.pieceAlliance != pieceAtPosition.getPieceAlliance()){
                            legalMoves.add(new AttackMove(board,this,candidateDestinationCoordinate,pieceAtPosition));
                        }
                    }
                }
                else if (currentCandidateOffset == 9 && !(BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack()||
                        BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite())){
                    if (!board.getTile(candidateDestinationCoordinate).isOccupied()){
                        final Piece pieceAtPosition = board.getTile(candidateDestinationCoordinate).getPiece();
                        if (this.pieceAlliance != pieceAtPosition.getPieceAlliance()){
                            legalMoves.add(new AttackMove(board,this,candidateDestinationCoordinate,pieceAtPosition));
                        }
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
}
