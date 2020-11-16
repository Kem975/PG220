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
        writer_log.print("Player ");
        writer_log.print(player_nbr);
        if(type ==0) {
            writer_log.print("is human ");
        }else{
            writer_log.print("is ia ");
        }
        writer_log.print(name+"\n");
        writer_log.close();
    }

    void writeRoundBegin() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Begin round\n");
        writer_log.close();
    }

    void writeTurn(int column, int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Player "+player_nbr+" plays "+column+"\n");
        writer_log.close();
    }

    void writeWin(int player_nbr) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Player "+player_nbr+" wins\n");
        writer_log.close();
    }

    void writeTie() throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Tie !\n");
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
        writer_log.print("Game finished\n");
        writer_log.close();
    }

    void writeError(String error) throws FileNotFoundException {
        PrintWriter writer_log = new PrintWriter(this.file);
        writer_log.print("Error : "+error+"\n");
        writer_log.close();
    }
}
