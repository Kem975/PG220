package game_components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

    String path = "./log.txt";
    File file;

    public Log() throws IOException {
        this.file = new File(this.path);
        this.file.createNewFile();
    }
    public void reset() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("");
        writer_log.close();
    }

    public void writePlayer(int player_nbr,int type, String name) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append("Joueur ");
        writer_log.append(String.format("%d",player_nbr));
        if(type ==0) {
            writer_log.append("est humain ");
        }else{
            writer_log.append("est ia ");
        }
        writer_log.append(name+"\n");
        writer_log.close();
    }

    public void writeRoundBegin() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append("Manche commence\n");
        writer_log.close();
    }

    public void writeTurn(int column, int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append(String.format("Joueur %d joue %d\n",player_nbr,column));
        writer_log.close();
    }

    public void writeWin(int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append(String.format("Joueur %d gagne\n",player_nbr));
        writer_log.close();
    }

    public void writeTie() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append("Egalite\n");
        writer_log.close();
    }

    public void writeScoreNbr(Player[] players) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append("Score : ");
        for(int i = 0; i< players.length-1;i++){
            writer_log.append(String.format("%d - ",players[i].getWin()));
        }
        writer_log.append(String.format("%d\n",players[players.length-1].getWin()));
        writer_log.close();
    }

    public void writeEnd() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.append("Partie finie\n");
        writer_log.close();
    }

    public void writeErrorName(int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur saisie Joueur "+player_nbr+"\n");
        writer_log.close();
    }

    public void writeErrorColumnName(String column) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur saisie colonne "+column+"\n");
        writer_log.close();
    }

    public void writeErrorColumnNbr(int column) throws  FileNotFoundException{
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur colonne non valide "+column+"\n");
        writer_log.close();
    }

    public void writeErrorColumnFull(int column) throws  FileNotFoundException{
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Erreur colonne pleine "+column+"\n");
        writer_log.close();
    }
}
