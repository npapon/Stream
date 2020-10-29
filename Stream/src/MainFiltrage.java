import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainFiltrage {

    public static void main( String[] args ) {
        List<Personne> liste = Arrays.asList( new Personne( 1.8d, 80.d, "Nicolas", "Papon", Couleur.BLEU ),
                new Personne( 1.60d, 50.d, "Leslie", "Papon", Couleur.MARRON ),
                new Personne( 0.60d, 8.d, "Sasha", "Papon", Couleur.VERT ) );

        System.out.println( "AVANT LE FILTRE" );
        // PETIT RAPPEL
        Stream stream = liste.stream();

        stream.forEach( new Consumer<Personne>() {

            @Override
            public void accept( Personne personne ) {
                System.out.println( personne );

            }
        } );

        Stream streamLambda = liste.stream();

        streamLambda.forEach( ( personne ) -> System.out.println( personne ) );

        Stream streamReferenceMethode = liste.stream();
        streamReferenceMethode.forEach( System.out::println );

        /*
         * je m'appelle Nicolas Papon et je pèse 80.0 et je me mesure 1.8 et
         * j'ai les yeux de couleur la couleur est bleu je m'appelle Leslie
         * Papon et je pèse 50.0 et je me mesure 1.6 et j'ai les yeux de couleur
         * la couleur est marron je m'appelle Sasha Papon et je pèse 8.0 et je
         * me mesure 0.6 et j'ai les yeux de couleur la couleur est vert
         */

        System.out.println( "APRES FILTRE" );

        // ON CREE UN STREAM
        Stream stream2 = liste.stream();

        // ON FILTRE LE STREAM ET ON L AFFICHE (DIRECTEMENT CAR SINON LE STREAM
        // EST EPUISE
        stream2.filter( new Predicate<Personne>() {

            @Override
            public boolean test( Personne personne ) {
                if ( personne.getPoids() > 50 ) {
                    return true;
                } else {
                    return false;
                }
            }
        } ).forEach( new Consumer<Personne>() {

            @Override
            public void accept( Personne personne ) {
                System.out.println( personne );

            }
        } );

        // ON AFFICHE LE RESULTAT DU STREAM
        // je m'appelle Nicolas Papon et je pèse 80.0 et je me mesure 1.8 et
        // j'ai les yeux de couleur la couleur est bleu

        // EN MODE LAMBDA
        Stream<Personne> stream3 = liste.stream();
        stream3.filter( ( personne ) -> {
            if ( personne.getPoids() > 50 ) {
                return true;
            } else {
                return false;
            }
        } ).forEach( ( personne ) -> System.out.println( personne ) );

        // EN MODE REFERENCE METHODE
        Stream<Personne> stream4 = liste.stream();
        stream4.filter( ( personne ) -> {
            if ( personne.getPoids() > 50 ) {
                return true;
            } else {
                return false;
            }
        } ).forEach( System.out::println );
    }

}
