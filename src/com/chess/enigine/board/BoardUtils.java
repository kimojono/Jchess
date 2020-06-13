package com.chess.enigine.board;

public class BoardUtils {
    public static final boolean[] FIRST_COLOMN = null;
    public static final boolean[] EIGHTH_COLOMN = null;
    public static final boolean[] SEVENTH_COLOMN = null;
    public static final boolean[] SECOND_COLOMN = null;

    public static boolean isValidTileCoordinate(int candidateDestinationCoordinate) {
        return candidateDestinationCoordinate < Board.getBoardSize() && candidateDestinationCoordinate >= 0;
    }
}
