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
                    grid[j][i] = '.';
                }
            }
        }
    }

    public int linearWin(int x, int y, int stepX, int stepY,char pion){
        int count = 0;
        for(int i=0;i<4;i++){
            if(x+i*stepX<0 || x+i*stepX > this.width || y+i*stepY<0 || y+i*stepY > this.length){
                return count;
            }
            if(this.grid[x+i*stepX][y+i*stepY] != pion){
                return count;
            }
            count++;
        }
        return count;
    }

    public boolean win(int x, int y, char pion){
        int count = 0;
        count = linearWin(x,y,1,0,pion) + linearWin(x,y,-1,0,pion);
        if(count>3){
            return true;
        }
        count = linearWin(x,y,0,1,pion) + linearWin(x,y,0,-1,pion);
        if(count>3){
            return true;
        }
        count = linearWin(x,y,1,-1,pion) + linearWin(x,y,-1,1,pion);
        if(count>3){
            return true;
        }
        count = linearWin(x,y,-1,-1,pion) + linearWin(x,y,1,1,pion);
        if(count>3){
            return true;
        }
        return false;
    }

    public int turn(int column,char pion){
        if(column >= 0 && column<this.width) {
            for (int i = this.length; i > 0; i++) {
                if (this.grid[column][i] == '.') {
                    this.grid[column][i] = pion;
                    return i;
                }
            }
        }
        return -1;
    }

    public void draw(){
        for(int i = 0; i<this.width;i++){
            System.out.print(i+1);
            System.out.print(" ");
        }
        System.out.println("");
        for (int j = 0; j<this.length;j++){
            for(int i = 0; i<this.width;i++){
                System.out.print(grid[j][i]);
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