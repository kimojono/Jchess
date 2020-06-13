package com.chess.enigine.piece;

import com.chess.enigine.Alliance;
import com.chess.enigine.board.Board;
import com.chess.enigine.board.Move;

import java.util.Collection;

public class Pawn extends Piece{
    private final int[] CANDIDATE_MOVE_COORDINATE = {-16,-8,8,16};
    public Pawn(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateMoves(Board board) {
        return null;
    }
}
