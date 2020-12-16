package game_components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {

    String path = "./log.txt";

    Log() throws IOException {
        Files.deleteIfExists(Paths.get(this.path));
        Files.createFile(Paths.get(this.path));
    }

    void reset() throws IOException {
        Files.write(Paths.get(this.path), "".getBytes(),StandardOpenOption.WRITE);
    }


    public void writePlayer(int player_nbr, int type, String name) throws IOException {
        
        String text = "Joueur "+String.format("%d", player_nbr);
        if (type == 0) {
            text = text+" est humain ";
        } else {
            text=text+" est ia ";
        }
        text = text+"\n";
        Files.write(Paths.get(this.path), text.getBytes(),StandardOpenOption.APPEND);
    }

    void writeRoundBegin() throws IOException {
        Files.write(Paths.get(this.path), "Manche commence\n".getBytes(),StandardOpenOption.APPEND);
    }

    void writeTurn(int column, int player_nbr) throws IOException {
        Files.write(Paths.get(this.path),String.format("Joueur %d joue %d\n", player_nbr, column).getBytes(),StandardOpenOption.APPEND);
    }

    void writeWin(int player_nbr) throws IOException {
        Files.write(Paths.get(this.path),String.format("Joueur %d gagne\n", player_nbr).getBytes(),StandardOpenOption.APPEND);
    }

    void writeTie() throws IOException {
        Files.write(Paths.get(this.path),"Egalite\n".getBytes(),StandardOpenOption.APPEND);
    }

    void writeScoreNbr(Player[] players) throws IOException {
        String text = "Score : ";
        for (int i = 0; i < players.length - 1; i++) {
            text = text+String.format("%d - ", players[i].getWin());
        }
        text = text+String.format("%d\n", players[players.length - 1].getWin());
        Files.write(Paths.get(this.path), text.getBytes(),StandardOpenOption.APPEND);
    }

    void writeEnd() throws IOException {
        Files.write(Paths.get(this.path), "Partie finie\n".getBytes(),StandardOpenOption.APPEND);
    }

    void writeErrorName(int player_nbr) throws IOException {      
        Files.write(Paths.get(this.path), String.format("Erreur saisie Joueur %d\n", player_nbr).getBytes(),StandardOpenOption.APPEND);
    }

    public void writeErrorColumnName(String column) throws IOException {
        Files.write(Paths.get(this.path), String.format("Erreur saisie colonne %s\n", column).getBytes(),StandardOpenOption.APPEND);
    }

    void writeErrorColumnNbr(int column) throws IOException {
        Files.write(Paths.get(this.path), String.format("Erreur colonne non valide %d\n", column).getBytes(),StandardOpenOption.APPEND);
    }

    void writeErrorColumnFull(int column) throws IOException {
        Files.write(Paths.get(this.path), String.format("Erreur colonne pleine %d\n", column).getBytes(),StandardOpenOption.APPEND);
    }
 }
