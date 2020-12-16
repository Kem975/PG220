package game_components;

import java.io.IOException;
import java.util.Scanner;

import game_components.players.*;
import game_components.rule_set.*;

public class Game {

    private Game() throws GridTailleException, IOException {
        Scanner in = new Scanner(System.in);
        Grid grid = newGrid(in);
        Rules[] rules = newRules(in);
        int nbRound = 4;

        int nbr = 2;

        Log log = new Log();
        log.reset();

        Player[] players = makePlayers(nbr, in, log);

        for (int i = 0; i < nbr; i++) {
            log.writePlayer(i, players[i].getType(), players[i].getName());
        }
        consoleDisplay(grid, players, nbRound, log, rules);

        in.close();
        freeAll(nbr, players);
    }

    public static void main(String[] args) throws GridTailleException, IOException {
        new Game();
    }

    private void consoleDisplay(Grid grid, Player[] players, int nbRound, Log log, Rules[] rules)
            throws GridTailleException, IOException {
        boolean isWin = false;
        boolean tie = false;
        int i = 0;
        grid.draw();
        while (!checkWin(players, nbRound)) {
            for (i = 0; i < players.length; i++) {
                int col = players[i].nextMove(grid);
                int x = grid.turn(col, players[i].getPawn(), log);
                while (x == -1) {
                    System.out.println("Incorrect move");
                    grid.draw();
                    col = players[i].nextMove(grid);
                    x = grid.turn(col, players[i].getPawn(), log);
                }
                log.writeTurn(col, i);
                grid.draw();
                for (int k = 0; k < rules.length; k++) {
                    if (isWin = rules[k].IsWin(x, col, players[i].getPawn(), grid)) {
                        break;
                    }
                }
                if (isWin) {

                    players[i].incWin();
                    System.out.println("Good job " + players[i].getName() + " with pawn " + players[i].getPawn());
                    log.writeScoreNbr(players);
                    if (players[i].getWin() == nbRound) {
                        log.writeEnd();
                        break;
                    } else {
                        grid = new Grid(grid.getLength(), grid.getWidth());
                        log.writeRoundBegin();
                        i = 0;
                    }
                }
                tie = grid.tie();
                if (tie) {
                    grid = new Grid(grid.getLength(), grid.getWidth());
                    log.writeTie();
                    i = 0;
                }
            }
        }
        if (isWin)
            System.out.println("Good job " + players[i].getName() + " with pawn " + players[i].getPawn());
    }

    private void freeAll(int nbr, Player players[]) {
        for (int p = 0; p < nbr; p++) {
            if (players[p].getType() == 0) {
                Human human = (Human) players[p];
                human.freeScanner();
            }
        }
    }

    private boolean checkWin(Player players[], int nbRound) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getWin() == nbRound)
                return true;
        }
        return false;
    }

    private Player[] makePlayers(int nbr, Scanner in, Log log) throws IOException {
        Player players[] = new Player[nbr];
        for (int i = 0; i < nbr; i++) {
            players[i] = newPlayer("Joueur " + (i + 1) + "?", in, i, log);
            while (!sameName(players, i)) {
                System.out.println("This name is already taken");
                players[i] = newPlayer("Player " + (i + 1) + " ?", in, i, log);
                log.writeErrorName(i);
            }
        }
        return players;
    }

    private Player newPlayer(String line, Scanner in, int i, Log log) {
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
            isSortir(player);
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
                return new Human(mot[1], pawn, log);
            } else if (mot[0].equals("ia")) {
                return new IARandom(mot[1], pawn);
            } else if (mot[0].equals("ia:random")) {
                return new IARandom(mot[1], pawn);
            } else if (mot[0].equals("ia:high")) {
                return new IAHighestBid(mot[1], pawn);
            } else {
                System.out.println("there");
                System.out.println("You need to specify a player type.");
                System.out.println("Example: human Joe");
                System.out.println("Or: ia Bob");
                continue;
            }

        }
    }

    private Rules[] newRules(Scanner in) {
        Rules[] rule_set = new Rules[1];
        rule_set[0] = new Basic(4);
        return rule_set;
    }

    public static Grid gridInit(int l, int w) throws GridTailleException {
        return new Grid(l, w);

    }

    private Grid newGrid(Scanner in) throws GridTailleException {
        return gridInit(6, 7);
    }

    private boolean sameName(Player players[], int idx) {
        Player player_to_add = players[idx];
        for (int i = 0; i < idx; i++) {
            Player player = players[i];
            if (player_to_add.getName().equals(player.getName()))
                return false;
        }
        return true;
    }

    private int checkInputInt(Scanner in, String str1, String str2, int gt) {
        int number;
        while (true) {
            System.out.println(str1);
            try {
                String tmp = in.nextLine();
                isSortir(tmp);
                number = Integer.parseInt(tmp);
                if (number >= gt)
                    break;
                else
                    System.out.println(str2);
            } catch (NumberFormatException ex) {
                System.out.println(str2);
            }
        }
        return number;
    }

    public static void isSortir(String input) {
        if (input.equals("sortir")) {
            System.exit(0);
        }
    }
}
