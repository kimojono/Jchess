package com.chess.enigine.piece;

import com.chess.enigine.Alliance;
import com.chess.enigine.board.Board;
import com.chess.enigine.board.Move;

import java.util.Collection;

public class Bishop extends Piece{
    private final static int[] CANDIDATE_MOVE_COORDINATE = {};

    public Bishop(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateMoves(Board board) {
        return null;
    }
}
