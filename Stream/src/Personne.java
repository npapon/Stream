
public class Personne {
    private Double  taille = 0.0d, poids = 0.0d;
    private String  nom    = "", prenom = "";
    private Couleur yeux   = Couleur.INCONNU;

    public Personne( Double taille, Double poids, String prenom, String nom, Couleur yeux ) {
        this.taille = taille;
        this.poids = poids;
        this.prenom = prenom;
        this.nom = nom;
        this.yeux = yeux;

    }

    public String toString() {
        return "je m'appelle " + prenom + " " + nom + " et je pèse " + poids + " et je me mesure " + taille
                + " et j'ai les yeux de couleur " + yeux;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille( Double taille ) {
        this.taille = taille;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids( Double poids ) {
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public Couleur getYeux() {
        return yeux;
    }

    public void setYeux( Couleur yeux ) {
        this.yeux = yeux;
    }

}
