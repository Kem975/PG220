import java.util.Scanner;

import game_components.players.*;
import game_components.*;

class Game {
    /*
     * private Grid grid; //private Set<Player> players; private static Player
     * player1; private static Player player2;
     */

    public static void main(String[] args) throws GridTailleException {
        Scanner in = new Scanner(System.in);
        Grid grid = newGrid(in);
        System.out.println("Number of player ?");
        int nbr = in.nextInt();
        Player players[] = new Player[nbr];
        for (int i = 0; i < nbr; i++) {
            players[i]=newPlayer("Player "+ (i+1) + " ?", in);
        }
        boolean isWin = false;
        boolean tie = false;
        System.out.println(grid.getLength());
        System.out.println(grid.getWidth());
        grid.draw();
        int i =0;
        while (!isWin && !tie) {
            for (i = 0; i < nbr; i++) {
                int col = players[i].Nextmove(grid, in);
                char pawn = (char) (65 +i);
                int x = grid.turn(col,pawn);
                while (x == -1) {
                    System.out.println("Incorrect move");
                    grid.draw();
                    col = players[i].Nextmove(grid, in);
                    x = grid.turn(col, pawn);
                }
                grid.draw();
                isWin = grid.win(x, col, pawn);
                tie = grid.tie();
                if (isWin || tie) {
                    break;
                }

            }
        }
        System.out.println("Good job "+players[i].GetNom());
        in.close();

    }

    private static Player newPlayer(String line, Scanner in) {
        while (true) {
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

    private static Grid newGrid(Scanner in) throws GridTailleException {
        while (true) {

            System.out.println("Width of the grid:");
            int width = in.nextInt();
            System.out.println("Length of the grid:");
            int length = in.nextInt();
            return new Grid(length, width);
        }
    }
}