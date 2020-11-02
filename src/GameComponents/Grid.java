package GameComponents;
public class Grid{

    int length;
    int width;
    char[][] grid;

    public Grid(int length, int width, char[][] grid) {
        this.length = length;
        this.width = width;
        this.grid = grid;
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