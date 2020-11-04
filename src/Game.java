

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
        Scanner in = new Scanner(System.in);
        Grid grid = newGrid(in);
        Player player1 = newPlayer("Player 1 ?",in);
        Player player2 = newPlayer("Player 2 ?",in);
        boolean isWin = false;
        while(!isWin) {
            grid.draw();
            int col = player1.Nextmove(grid,in);
            int x = grid.turn(col, 'o');
            grid.draw();
            isWin=grid.win(x, col, 'o');
            if (isWin) {
                break;
            }
            col = player2.Nextmove(grid,in);
            x=grid.turn(col,'x');
            isWin=grid.win(x, col, 'x');

        }
        in.close();
        
    }

    private static Player newPlayer(String line,Scanner in)  {
        while(true) {
            System.out.println(line);
            String player = in.nextLine();
            String mot[] = player.split(" ");
            if (mot.length < 2) {
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

    private static Grid newGrid(Scanner in) {
        while(true) {
            
            System.out.println("Width of the grid:");
            int width = in.nextInt();
            System.out.println("Length of the grid:");
            int length = in.nextInt();
            return new Grid(length,width);
        }
    }
}