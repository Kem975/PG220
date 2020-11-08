package game_components;

public class Grid {

    private int length;
    private int width;
    private char[][] grid;
    private int empty_case;

    public Grid(int length, int width) {
        if (length >= 8 && width >= 7) {
            this.length = length;
            this.width = width;
            this.grid = new char[this.length][this.width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = '.';
                }
            }
            this.empty_case = length * width;
        }
    }

    public boolean tie() {
        if (empty_case == 0) {
            return true;
        }
        return false;
    }

    public int linearWin(int x, int y, int stepX, int stepY, char pion) {
        int count = 0;
        for (int i = 1; i < 4; i++) {
            if (x + i * stepX < 0 || x + i * stepX > this.length - 1 || y + i * stepY < 0
                    || y + i * stepY > this.width - 1) {
                return count;
            }
            if (this.grid[x + i * stepX][y + i * stepY] != pion) {
                return count;
            }
            count++;
        }
        return count;
    }

    public boolean win(int x, int y, char pion) {
        int count = 0;
        count = linearWin(x, y, 1, 0, pion) + linearWin(x, y, -1, 0, pion) + 1;
        if (count >= 4) {
            return true;
        }
        count = linearWin(x, y, 0, 1, pion) + linearWin(x, y, 0, -1, pion) + 1;
        if (count >= 4) {
            return true;
        }
        count = linearWin(x, y, 1, -1, pion) + linearWin(x, y, -1, 1, pion) + 1;
        if (count >= 4) {
            return true;
        }
        count = linearWin(x, y, -1, -1, pion) + linearWin(x, y, 1, 1, pion) + 1;
        if (count >= 4) {
            return true;
        }
        return false;
    }

    public int turn(int column, char pion) {
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

    public void setLength(int length) {
        this.length = length;
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

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
}