package game_components.players;

import game_components.Player;
import game_components.Grid;

public class IAHighestBid extends Player{
    
    
    public IAHighestBid(String name,char pawn){
        super(name,pawn,1);
    }

    public int nextMove(Grid grid) {
        float min = 800;
        int column = 0;
        int length = grid.getLength();
        int width = grid.getWidth();
        float midx = (float)width / 2;
        float midy = (float)length / 2;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid.getGrid()[i][j]=='.') {
                    float valx = Math.abs(i-midx);
                    float valy = Math.abs(j-midy);
                    float finalVal= valx+ valy;
                    if (finalVal < min) {
                        min = finalVal;
                        column = j;
                    }

                }
            }
            
        }
        return column;


    }
}
