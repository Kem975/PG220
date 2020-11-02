abstract class Player {
    String nom;
    int type;

    public Player(String nom, int type){
        this.nom = nom;
        this.type = type;
    }

    Nextmove(int colonne);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}