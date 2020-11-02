package game_components.players;

public class Human extends Player {

    public Human(String name){
        super(name, 0);
    }

    int Nextmove(Grid grille){
        Scanner sc = new Scanner(System.in);
        int colonne = sc.nextInt();
        if(colonne>0 && colonne<=grille.getlength()){
            return colonne;
        }
        else{
            System.out.println("Colonne non valide\n");
        }
    }
}