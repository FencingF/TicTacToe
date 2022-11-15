package org.fenci.tictactoe.game.board;

public enum Cube {
    TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT;

    public static Cube fromInt(int i) {
        switch (i) {
            case 0:
                return TOP_LEFT;
            case 1:
                return TOP_MIDDLE;
            case 2:
                return TOP_RIGHT;
            case 3:
                return MIDDLE_LEFT;
            case 4:
                return MIDDLE_MIDDLE;
            case 5:
                return MIDDLE_RIGHT;
            case 6:
                return BOTTOM_LEFT;
            case 7:
                return BOTTOM_MIDDLE;
            case 8:
                return BOTTOM_RIGHT;
            default:
                return null;
        }
    }

    public static int toInt(Cube cube) {
        switch (cube) {
            case TOP_LEFT:
                return 0;
            case TOP_MIDDLE:
                return 1;
            case TOP_RIGHT:
                return 2;
            case MIDDLE_LEFT:
                return 3;
            case MIDDLE_MIDDLE:
                return 4;
            case MIDDLE_RIGHT:
                return 5;
            case BOTTOM_LEFT:
                return 6;
            case BOTTOM_MIDDLE:
                return 7;
            case BOTTOM_RIGHT:
                return 8;
            default:
                return -1;
        }
    }

    public static int[] getMiddleCoordinates(Cube cube) { //TODO: Check this it might be wrong idk
        switch (cube) {
            case TOP_LEFT:
                return new int[]{150, 150};
            case TOP_MIDDLE:
                return new int[]{250, 150};
            case TOP_RIGHT:
                return new int[]{350, 150};
            case MIDDLE_LEFT:
                return new int[]{150, 250};
            case MIDDLE_MIDDLE:
                return new int[]{250, 250};
            case MIDDLE_RIGHT:
                return new int[]{350, 250};
            case BOTTOM_LEFT:
                return new int[]{150, 350};
            case BOTTOM_MIDDLE:
                return new int[]{250, 350};
            case BOTTOM_RIGHT:
                return new int[]{350, 350};
            default:
                return null;
        }
    }
}
