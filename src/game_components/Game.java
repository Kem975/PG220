package game_components;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private Grid grid;
    //private Set<Player> players;
    private Player player1;
    private Player player2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Width of the grid:");
        int width = in.nextInt();
        System.out.println("Length of the grid:");
        int length = in.nextInt();
        System.out.println("Player 1?");
        String player1 = in.nextLine();
        System.out.println("Player 2?");
        String player2 = in.nextLine();
    }
}