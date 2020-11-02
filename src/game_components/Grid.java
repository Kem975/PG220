package game_components;


public class Grid {

    private int length;
    private int width;
    private char[][] grid;

    public Grid(int length, int width) {
        if(length>0 && width>0) {
            this.length = length;
            this.width = width;
            this.grid = new char[this.length][this.width];
            for (int j = 0; j < length; j++) {
                for (int i = 0; i < width; i++) {
                    grid[i][j] = '.';
                }
            }
        }
    }

    public boolean win(int x, int y){
        return 1>0;
    }

    public void turn(int column,char pion){
        if(column >= 0 && column<this.width) {
            for (int i = this.length; i > 0; i++) {
                if (this.grid[column][i] == '.') {
                    this.grid[column][i] = pion;
                    break;
                }
            }
        }
    }

    public void draw(){
        for(int i = 0; i<this.width;i++){
            System.out.println(i+1);
            System.out.println(" ");
        }
        for (int j = 0; j<this.length;j++){
            for(int i = 0; i<this.width;i++){
                System.out.println(grid[i][j]);
                System.out.println(" ");
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