package com.chess.enigine.board;

public class BoardUtils {
    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PRE_COLUMN = 8;
    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final boolean[] SECOND_ROW = initRow(1);
    public static final boolean[] SEVENTH_ROW = initRow(6);

    private static boolean[] initRow(int rowNum) {
        final boolean[] allTiles = new boolean[NUM_TILES];
        for (int i = NUM_TILES_PRE_COLUMN * rowNum;i<NUM_TILES_PRE_COLUMN * (rowNum+1);i++){
            allTiles[i] = true;
        }
        return allTiles;
    }

    private static boolean[] initColumn(int columnNum){
        final boolean[] allTiles = new boolean[NUM_TILES];
        for (;columnNum<NUM_TILES;columnNum+=NUM_TILES_PRE_COLUMN){
            allTiles[columnNum] = true;
        }
        return  allTiles;
    }

    public static boolean isValidTileCoordinate(final int candidateDestinationCoordinate) {
        return candidateDestinationCoordinate < Board.getBoardSize() && candidateDestinationCoordinate >= 0;
    }
}
