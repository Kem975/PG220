package game_components.rule_set;

import game_components.Rules;
import game_components.Grid;

public class Basic extends Rules{

    public Basic(int pounds) {
        super(pounds);
    }

    public int linearWin(int x, int y, int stepX, int stepY, char pion, Grid grid) {
        int count = 0;
        for (int i = 1; i < 4; i++) {
            if (x + i * stepX < 0 || x + i * stepX > grid.getLength() - 1 || y + i * stepY < 0
                    || y + i * stepY > grid.getWidth() - 1) {
                return count;
            }
            if (grid.getGrid()[x + i * stepX][y + i * stepY] != pion) {
                return count;
            }
            count++;
        }
        return count;
    }


    public boolean IsWin(int x, int y, char pion, Grid grid) {
        int count = 0;
        count = linearWin(x, y, 1, 0, pion, grid) + linearWin(x, y, -1, 0, pion, grid) + 1;
        if (count >= this.PoundsToWin) {
            return true;
        }
        count = linearWin(x, y, 0, 1, pion, grid) + linearWin(x, y, 0, -1, pion, grid) + 1;
        if (count >= this.PoundsToWin) {
            return true;
        }
        count = linearWin(x, y, 1, -1, pion, grid) + linearWin(x, y, -1, 1, pion, grid) + 1;
        if (count >= this.PoundsToWin) {
            return true;
        }
        count = linearWin(x, y, -1, -1, pion, grid) + linearWin(x, y, 1, 1, pion, grid) + 1;
        if (count >= this.PoundsToWin) {
            return true;
        }
        return false;
    }



}
