import java.util.Scanner;

import game_components.players.*;
import game_components.*;

class Game {
    public static void main(String[] args) throws GridTailleException {
        Scanner in = new Scanner(System.in);
        Grid grid = newGrid(in);
        int nbr;

        while (true) {
            System.out.println("Number of player ?");
            try {
                nbr = Integer.parseInt(in.nextLine());
                if (nbr >= 2)
                    break;
                else
                    System.out.println("Must be a number greater than 2");
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 2");
            }
        }
        
        Player players[] = new Player[nbr];
        System.out.println("Chose the Player type :\n- human <name>\n- ia <name>");
        for (int i = 0; i < nbr; i++) {
            players[i]=newPlayer("Player "+ (i+1) + " ?", in,i);
            while(!same_name(players, i)){
                System.out.println("This name is already taken");
                players[i] = newPlayer("Player "+ (i+1) + " ?", in,i);
            }
        }

        boolean isWin = false;
        boolean tie = false;
        grid.draw();
        int i =0;
        while (!checkWin(players)) {
            for (i = 0; i < nbr; i++) {
                int col = players[i].nextmove(grid, in);
                int x = grid.turn(col,players[i].getPawn());
                while (x == -1) {
                    System.out.println("Incorrect move");
                    grid.draw();
                    col = players[i].nextmove(grid, in);
                    x = grid.turn(col, players[i].getPawn());
                }
                grid.draw();
                isWin = grid.win(x, col, players[i].getPawn());
                if (isWin) {
                    players[i].incWin();
                    System.out.println("Good job "+players[i].getName()+" with pawn " + players[i].getPawn());
                    if (players[i].getWin() == 3) 
                        break;
                    else {
                        grid = new Grid(grid.getLength(),grid.getWidth(),grid.getWin());
                        i=0;
                    }
                }
                tie = grid.tie();
                if (tie) {
                    grid = new Grid(grid.getLength(),grid.getWidth(),grid.getWin());
                    i=0;
                }
            }
        }
        if (isWin)
            System.out.println("Good job "+players[i].getName()+" with pawn " + players[i].getPawn());
        in.close();

    }

    private static boolean checkWin(Player players[]) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getWin() == 3)
                return true;
        }
        return false;
    }


    private static Player newPlayer(String line, Scanner in,int i) {
        char pawn;
        switch (i) {
            case 0:
                pawn = 'X';
                break;
            case 1:
                pawn = 'O';
                break;
            default:
                pawn = (char) (i + 65);
                break;
        }
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
                return new Human(mot[1],pawn);
            } else if (mot[0].equals("ia")) {
                return new IARandom(mot[1],pawn);
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

        int width;
        int length;
        int winc;
        while (true) {
            System.out.println("\n\n[WELCOME TO THE BEST CONNECT FOUR]\n\n");
            System.out.println("Width of the grid:");
            try {
                width = Integer.parseInt(in.nextLine());
                if (width >= 7)
                    break;
                else
                    System.out.println("Must be a number greater than 7.");
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 7.");
            }
        }

        while (true) {
            System.out.println("Length of the grid:");
            try {
                length = Integer.parseInt(in.nextLine());
                if (length >= 4 && length %2 == 0)
                    break;
                else
                    System.out.println("Must be a number greater than 4 and even.");
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 4 and even.");
            }
        }

        while (true) {
            System.out.println("Number of pawns to win:");
            try {
                winc = Integer.parseInt(in.nextLine());
                if (winc >= 3)
                    break;
                else
                    System.out.println("Must be a number greater than 3");
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 3");
            }
        }
        
        
        return new Grid(length, width,winc);
    }

    private static boolean same_name(Player players[], int idx){
        Player player_to_add = players[idx];
        for(int i = 0; i<idx; i++){
            Player player = players[i];
            if(player_to_add.getName().equals(player.getName()))
                return false;
        }
        return true;
    }
}