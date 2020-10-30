import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainReduce {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        List<Personne> liste = Arrays.asList( new Personne( 1.8d, 80.d, "Nicolas", "Papon", Couleur.BLEU ),
                new Personne( 1.60d, 50.d, "Leslie", "Papon", Couleur.MARRON ),
                new Personne( 0.60d, 8.d, "Sasha", "Papon", Couleur.VERT ) );

        Stream<Personne> stream = liste.stream();

        Double sommePoids = stream.filter( new Predicate<Personne>() {

            @Override
            public boolean test( Personne personne ) {
                if ( personne.getPoids() > 49 ) {
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
        } ).reduce( 0.d, new BinaryOperator<Double>() {

            @Override
            public Double apply( Double variable1, Double variable2 ) {
                double operationMathematique = variable1 + variable2;
                return operationMathematique;
            }
        } );

        System.out.println( sommePoids );

        // 130

        // ecriture en mode simplifié

        Stream<Personne> stream2 = liste.stream();

        Double sommePoids2 = stream2.filter( ( personne ) -> personne.getPoids() > 1 ).map( ( personne ) -> personne.getPoids() )
                .reduce( 0d,
                        ( variable1, variable2 ) -> variable1 + variable2 );

        System.out.println( sommePoids2 );

        // 138

    }

}
