package game_components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

    String path = "./log.txt";
    File file;

    Log() throws IOException {
        this.file = new File(this.path);
        this.file.createNewFile();
    }
    void reset() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("");
        writer_log.close();
    }

    void writePlayer(int player_nbr,int type, String name) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Joueur ");
        writer_log.print(player_nbr);
        if(type ==0) {
            writer_log.print("est humain ");
        }else{
            writer_log.print("est ia ");
        }
        writer_log.print(name+"\n");
        writer_log.close();
    }

    void writeRoundBegin() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Manche commence\n");
        writer_log.close();
    }

    void writeTurn(int column, int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Joueur "+player_nbr+" joue "+column+"\n");
        writer_log.close();
    }

    void writeWin(int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Joueur "+player_nbr+" gagne\n");
        writer_log.close();
    }

    void writeTie() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Egalite\n");
        writer_log.close();
    }

    void writeScoreNbr(Player[] players) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Score : ");
        for(int i = 0; i< players.length-1;i++){
            writer_log.print(players[i].getWin()+" - ");
        }
        writer_log.print(players[players.length-1].getWin()+"\n");
        writer_log.close();
    }

    void writeEnd() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Partie finie\n");
        writer_log.close();
    }

    void writeErrorName(int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur saisie Joueur "+player_nbr+"\n");
        writer_log.close();
    }

    void writeErrorColumnName(String column) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur saisie colonne "+column+"\n");
        writer_log.close();
    }

    void writeErrorColumnNbr(int column) throws  FileNotFoundException{
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur colonne non valide "+column+"\n");
        writer_log.close();
    }

    void writeErrorColumnFull(int column) throws  FileNotFoundException{
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur colonne pleine "+column+"\n");
        writer_log.close();
    }
}
