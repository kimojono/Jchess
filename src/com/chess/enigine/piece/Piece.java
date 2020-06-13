package com.chess.enigine.piece;

import com.chess.enigine.board.Board;
import com.chess.enigine.board.Move;
import com.chess.enigine.Alliance;

import java.util.Collection;


public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    public Alliance getPieceAlliance() {
        return pieceAlliance;
    }

    public int getPiecePosition() {
        return piecePosition;
    }


    public Piece(int piecePosition, Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }
    public abstract Collection<Move> calculateMoves(final Board board);
}
