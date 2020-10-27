import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

    public static void main( String[] args ) {

        // ON CREE UNE LISTE
        // Arrays.asList transforme un tableau en list

        List<Personne> liste = Arrays.asList( new Personne( 1.8d, 80.d, "Nicolas", "Papon", Couleur.BLEU ),
                new Personne( 1.60d, 50.d, "Leslie", "Papon", Couleur.MARRON ),
                new Personne( 0.60d, 8.d, "Sasha", "Papon", Couleur.VERT ) );

        System.out.println( "RAPPEL SUR CONSUMMER" );

        Consumer<Personne> consumer = new Consumer<Personne>() {

            @Override
            public void accept( Personne personne ) {
                System.out.println( personne );

            }
        };
        consumer.accept( new Personne( 0.60d, 8.d, "Sasha", "Papon", Couleur.VERT ) );

        // CONSOLE :
        // je m'appelle Sasha Papon et je pèse 8.0 et je me mesure 0.6 et j'ai
        // les yeux de couleur la couleur est vert
        System.out.println( "ET SI ON PARCOURE DIRECTEMENT LA LISTE" );

        for ( Personne personne : liste ) {

            new Consumer<Personne>() {

                @Override
                public void accept( Personne personne ) {
                    System.out.println( personne );

                }
            };

        }

        // CONSOLE :
        //
        System.out.println( "CA N AFFICHE RIEN DANS LA CONSOLE" );

        System.out.println( "ON CREE UN STREAM" );
        // ON CREE UN STREAM SUR LA LIST
        Stream<Personne> stream = liste.stream();

        // POUR CHAQUE PERSONNE DE LA LISTE, LA CONTRAIREMENT A LA LISTE CA
        // APPLIQUE ACCEPT DIRECTEMENT

        stream.forEach( new Consumer<Personne>() {

            @Override
            public void accept( Personne personne ) {
                System.out.println( personne );

            }
        } );

        System.out.println( "SIMPLIFIONS L ECRITURE DU STREAM AVEC LES LAMBDA PUIS REFERENCE SUR METHODE" );

        stream.forEach( ( personne ) -> System.out.println( personne ) );
        // GENERE UNE ILLEGALSTATE EXCEPTION CAR DEJA utilisé

        Stream<Personne> stream2 = liste.stream();

        stream2.forEach( System.out::println );

        // GENERE UNE ILLEGALSTATE EXCEPTION CAR DEJA utilisé

        Stream.iterate( 1, ( x ) -> x + 1 ).forEach( System.out::println );

    }

}
