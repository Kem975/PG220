package game_components;

import java.io.IOException;

public class Grid {

    private int length;
    private int width;
    private char[][] grid;
    private int empty_case;
    private int winc;

    public Grid(int length, int width) throws GridTailleException {
        if (length >= 4 && length % 2 == 0 && width >= 7) {
            this.length = length;
            this.width = width;
            this.grid = new char[this.length][this.width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = '.';
                }
            }
            this.empty_case = length * width;
        } else {
            throw new GridTailleException();
        }
    }

    public boolean tie() {
        if (empty_case == 0) {
            return true;
        }
        return false;
    }

    public int turn(int column, char pion, Log log) throws IOException {
        if (column >= 0 && column < this.width) {
            for (int i = this.length - 1; i >= 0; i--) {
                if (this.grid[i][column] == '.') {
                    this.grid[i][column] = pion;
                    this.empty_case--;
                    return i;
                }
            }
            log.writeErrorColumnFull(column);
        }
        else{
            log.writeErrorColumnNbr(column);
        }
        return -1;
    }

    public int turnNoLog(int column, char pion){
        if (column >= 0 && column < this.width) {
            for (int i = this.length - 1; i >= 0; i--) {
                if (this.grid[i][column] == '.') {
                    this.grid[i][column] = pion;
                    this.empty_case--;
                    return i;
                }
            }
        }
        return -1;
    }

    public void draw() {
        for (int i = 0; i < this.width; i++) {
            System.out.print(i + 1);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }

    public int getLength() {
        return length;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getWinc() {
        return winc;
    }

}