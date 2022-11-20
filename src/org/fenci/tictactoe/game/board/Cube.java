package org.fenci.tictactoe.game.board;

public enum Cube {
    TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT;

    public static Cube fromInt(int i) {
        switch (i) {
            case 1:
                return TOP_LEFT;
            case 2:
                return TOP_MIDDLE;
            case 3:
                return TOP_RIGHT;
            case 4:
                return MIDDLE_LEFT;
            case 5:
                return MIDDLE_MIDDLE;
            case 6:
                return MIDDLE_RIGHT;
            case 7:
                return BOTTOM_LEFT;
            case 8:
                return BOTTOM_MIDDLE;
            case 9:
                return BOTTOM_RIGHT;
            default:
                return null;
        }
    }

    public static int toInt(Cube cube) {
        switch (cube) {
            case TOP_LEFT:
                return 1;
            case TOP_MIDDLE:
                return 2;
            case TOP_RIGHT:
                return 3;
            case MIDDLE_LEFT:
                return 4;
            case MIDDLE_MIDDLE:
                return 5;
            case MIDDLE_RIGHT:
                return 6;
            case BOTTOM_LEFT:
                return 7;
            case BOTTOM_MIDDLE:
                return 8;
            case BOTTOM_RIGHT:
                return 9;
            default:
                return -1;
        }
    }

    public static int[] getMiddleCoordinates(Cube cube) { //TODO: Check this it might be wrong idk
        switch (cube) {
            case TOP_LEFT:
                return new int[]{150 , 150};
            case TOP_MIDDLE:
                return new int[]{250 , 150};
            case TOP_RIGHT:
                return new int[]{350 , 150};
            case MIDDLE_LEFT:
                return new int[]{150 , 250};
            case MIDDLE_MIDDLE:
                return new int[]{250 , 250};
            case MIDDLE_RIGHT:
                return new int[]{350 , 250};
            case BOTTOM_LEFT:
                return new int[]{150 , 350};
            case BOTTOM_MIDDLE:
                return new int[]{250 , 350};
            case BOTTOM_RIGHT:
                return new int[]{350 , 350};
            default:
                return null;
        }
    }
}
