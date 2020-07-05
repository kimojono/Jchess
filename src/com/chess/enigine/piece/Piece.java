package com.chess.enigine.piece;

import com.chess.enigine.board.Board;
import com.chess.enigine.board.Move;
import com.chess.enigine.Alliance;

import java.util.Collection;


public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;
    protected final boolean isFirstMove;
    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }
    public boolean isFirstMove(){
        return this.isFirstMove;
    }


    public Piece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        this.isFirstMove = false;
    }
    public abstract Collection<Move> calculateMoves(final Board board);
}
