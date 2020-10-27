
public enum Couleur {

    MARRON( "marron" ), VERT( "vert" ), BLEU( "bleu" ), INCONNU( "inconnu" );

    private String signification;

    Couleur( String signification ) {
        this.signification = signification;
    }

    public String toString() {
        return "la couleur est " + signification;
    }

}
