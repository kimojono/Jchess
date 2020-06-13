package com.chess.enigine.piece;

import com.chess.enigine.Alliance;
import com.chess.enigine.board.Board;
import com.chess.enigine.board.BoardUtils;
import com.chess.enigine.board.Move.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bishop extends Piece{
    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATE = {-9,-7,7,9};
    public Bishop(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();
        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATE){
            int candidateDestinationCoordinate = this.piecePosition;
            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                candidateDestinationCoordinate+=candidateCoordinateOffset;
                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                    legalMoves.add(new AttackMove())
                }
            }
        }
    }
}
