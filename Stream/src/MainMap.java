import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainMap {

    public static void main( String[] args ) {
        List<Personne> liste = Arrays.asList( new Personne( 1.8d, 80.d, "Nicolas", "Papon", Couleur.BLEU ),
                new Personne( 1.60d, 50.d, "Leslie", "Papon", Couleur.MARRON ),
                new Personne( 0.60d, 8.d, "Sasha", "Papon", Couleur.VERT ) );

        // MAP permet de d'en le forEach de retourner que l'info qui est
        // interessante dans le filtre (80)
        Stream<Personne> stream = liste.stream();
        stream.filter( new Predicate<Personne>() {

            @Override
            public boolean test( Personne personne ) {
                if ( personne.getPoids() > 50 ) {
                    return true;
                } else {
                    return false;
                }
            }
        } ).map( new Function<Personne, Double>() {

            @Override
            public Double apply( Personne personne ) {
                // TODO Auto-generated method stub
                return personne.getPoids();
            }
        } ).forEach( new Consumer<Double>() {

            @Override
            public void accept( Double poids ) {
                System.out.println( poids );

            }
        } );
        ;

        // 80.0

        // en mode short reference Methode
        Stream<Personne> stream2 = liste.stream();
        stream2.filter( ( personne ) -> {
            if ( personne.getPoids() > 50 ) {
                return true;
            } else {
                return false;
            }

        } ).map( ( personne ) -> personne.getPoids() ).forEach( System.out::println );
        ;

    }

}
