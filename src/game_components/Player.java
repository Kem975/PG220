abstract class Player {
    private String nom;
    private int type;

    public Player(String nom, int type){
        this.nom = nom;
        this.type = type;
    }

    int Nextmove(Grid grille);

}