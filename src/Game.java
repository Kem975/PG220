

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

import game_components.players.*;
import game_components.*;

class Game {
    /*private Grid grid;
    //private Set<Player> players;
    private static Player player1;
    private static Player player2;*/

    public static void main(String[] args) {
        Grid grid = newGrid();
        Player player1 = newPlayer("Player 1 ?");
        Player player2 = newPlayer("Player 2 ?");
        boolean isWin = false;
        while(!isWin) {
            grid.draw();
            int col = player1.Nextmove(grid);
            int y = grid.turn(col, 'o');
            isWin=grid.win(col, y, 'o');

        }
        
    }

    private static Player newPlayer(String line)  {
        while(true) {
            System.out.println(line);
            Scanner in = new Scanner(System.in);
            String player = in.nextLine();
            String mot[] = player.split(" ");
            if (mot.length < 2) {
                System.out.println("Here");
                System.out.println("You need to specify a player type.");
                System.out.println("Example: human Joe");
                System.out.println("Or: ia Bob");
                continue;
            }
            if (mot[0].equals("human")) {
                return new Human(mot[1]);
            } else if (mot[0].equals("ia")) {
                return new IARandom(mot[1]);
            } else {
                System.out.println("there");
                System.out.println("You need to specify a player type.");
                System.out.println("Example: human Joe");
                System.out.println("Or: ia Bob");
                continue;
            }

        }
    }

    private static Grid newGrid() {
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Width of the grid:");
            int width = in.nextInt();
            System.out.println("Length of the grid:");
            int length = in.nextInt();
            return new Grid(width,length);
        }
    }
}