package game_components.rule_set;

import game_components.rule_set.Rules;
import game_components.Grid;


public class Square extends Rules {

    public Square() {}

    int linearWin(int x, int y, int stepX, int stepY, char pion, Grid grid) {
        if (x + stepX < 0 || x + stepX > grid.getLength() - 1 || y + stepY < 0
                || y + stepY > grid.getWidth() - 1) {
            return 0;
        }
        if (grid.getGrid()[x + stepX][y + stepY] != pion || grid.getGrid()[x + stepX][y] != pion || grid.getGrid()[x][y + stepY] != pion) {
            return 0;
        }
        return 4;
    }


    public boolean IsWin(int x, int y, char pion, Grid grid) {
        int count = 0;
        count = linearWin(x, y, 1, 1, pion, grid);
        if (count >= this.PawnsToWin) {
            return true;
        }
        count = linearWin(x, y, -1, 1, pion, grid);
        if (count >= this.PawnsToWin) {
            return true;
        }
        count = linearWin(x, y, 1, -1, pion, grid);
        if (count >= this.PawnsToWin) {
            return true;
        }
        count = linearWin(x, y, -1, -1, pion, grid);
        if (count >= this.PawnsToWin) {
            return true;
        }
        return false;
    }

}
