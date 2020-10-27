import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MainStreamInfini {

    public static void main( String[] args ) {

        // EN MOODE ANONYME
        Stream.iterate( 1, new UnaryOperator<Integer>() {

            @Override
            public Integer apply( Integer integer ) {
                integer = integer + 1;
                try {
                    Thread.sleep( 2000 );
                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return integer;
            }
        } ).limit( 3 ).forEach( new Consumer<Integer>() {

            @Override
            public void accept( Integer integer ) {
                System.out.println( integer );

            }
        } );
        ;

        // EN MOODE LAMBDA
        Stream.iterate( 1, ( Integer integer ) -> {
            integer = integer + 1;
            try {
                Thread.sleep( 2000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return integer;
        } ).limit( 3 ).forEach( ( Integer integer ) -> {

            System.out.println( integer );

        } );
        ;

        // EN MODE REFERENCE DE METHODE

        Stream.iterate( 1, ( Integer integer ) -> {
            integer = integer + 1;
            try {
                Thread.sleep( 2000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return integer;
        } ).forEach( System.out::println );

    }

}
