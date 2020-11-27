import java.io.IOException;
import java.util.Scanner;

import game_components.players.*;
import game_components.*;
import game_components.rule_set.*;

class Game {
    public static void main(String[] args) throws GridTailleException, IOException {
        Scanner in = new Scanner(System.in);
        Grid grid = newGrid(in);
        Rules rules = newRules(in);
        int nbRound;
        while (true) {
            System.out.println("Best of how many round?");
            try {
                nbRound = Integer.parseInt(in.nextLine());
                if (nbRound > 0)
                    break;
                else
                    System.out.println("Must be a positive number.");
            }catch (NumberFormatException ex) {
                System.out.println("Must be a positive number.");
            }
        }
        int nbr;
        Log log = new Log();
        log.reset();
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
        System.out.println("Choose the Player type :\n- human <name>\n- ia <name>\n- ia:random <name>\n- ia:high <name>");
        for (int i = 0; i < nbr; i++) {
            players[i]=newPlayer("Player "+ (i+1) + " ?", in,i,log);
            while(!same_name(players, i)){
                System.out.println("This name is already taken");
                players[i] = newPlayer("Player "+ (i+1) + " ?", in,i,log);
                log.writeErrorName(i);
            }
        }

        for (int i=0;i<nbr;i++){
            log.writePlayer(i,players[i].getType(),players[i].getName());
        }

        boolean isWin = false;
        boolean tie = false;
        grid.draw();
        int i =0;
        while (!checkWin(players,nbRound)) {
            for (i = 0; i < nbr; i++) {
                int col = players[i].nextMove(grid);
                int x = grid.turn(col,players[i].getPawn(),log);
                while (x == -1) {
                    System.out.println("Incorrect move");
                    grid.draw();
                    col = players[i].nextMove(grid);
                    x = grid.turn(col, players[i].getPawn(),log);
                }
                log.writeTurn(col,i);
                grid.draw();
                isWin = rules.IsWin(x, col, players[i].getPawn(), grid);
                if (isWin) {
                    players[i].incWin();
                    System.out.println("Good job "+players[i].getName()+" with pawn " + players[i].getPawn());
                    log.writeScoreNbr(players);
                    if (players[i].getWin() == nbRound) {
                        log.writeEnd();
                        break;
                    }
                    else {
                        grid = new Grid(grid.getLength(),grid.getWidth());
                        log.writeRoundBegin();
                        i=0;
                    }
                }
                tie = grid.tie();
                if (tie) {
                    grid = new Grid(grid.getLength(),grid.getWidth());
                    log.writeTie();
                    i=0;
                }
            }
        }
        if (isWin)
            System.out.println("Good job "+players[i].getName()+" with pawn " + players[i].getPawn());
        in.close();
        for(int p=0;p<nbr;p++){
            if(players[p].getType()==0){
                Human human = (Human)players[p];
                human.freeScanner();
            }
        }
    }

    private static boolean checkWin(Player players[],int nbRound) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getWin() == nbRound)
                return true;
        }
        return false;
    }


    private static Player newPlayer(String line, Scanner in,int i, Log log) {
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
                try {
                    log.writeErrorName(i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("You need to specify a player type.");
                System.out.println("Example: human Joe");
                System.out.println("Or: ia Bob");
                continue;
            }
            if (mot[0].equals("human")) {
                return new Human(mot[1],pawn, log);
            } else if (mot[0].equals("ia")) {
                return new IARandom(mot[1],pawn);
            } else if (mot[0].equals("ia:random")) {
                return new IARandom(mot[1],pawn); 
            } else if (mot[0].equals("ia:high")) {
                return new IAHighestBid(mot[1],pawn); 
            } else {
                System.out.println("there");
                System.out.println("You need to specify a player type.");
                System.out.println("Example: human Joe");
                System.out.println("Or: ia Bob");
                continue;
            }

        }
    }

    private static Rules newRules(Scanner in){
        int winc;

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
        return new Basic(winc);
    }


    private static Grid newGrid(Scanner in) throws GridTailleException {

        int width;
        int length;
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
        
        
        return new Grid(length, width);
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