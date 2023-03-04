import java.util.Scanner;
/**
 * Esta clase contiene métodos para generar un vector de números primos utilizando
 * el algoritmo de la criba de Eratóstenes.
 */
public class CribarPrimos
{

    /**
     * Genera un vector de números primos hasta el número máximo dado.
     *
     * @param numeroMaximo el número máximo hasta el cual se generarán los números primos
     * @return un vector de números primos hasta el número máximo
     */
    public static int[] generarPrimosHastaMax(int numeroMaximo)
    {
        if (numeroMaximo >= 2) {
            boolean[] esPrimo = new boolean[numeroMaximo + 1];
            inicializarVectorPrimos(esPrimo);
            buscarPrimos(esPrimo);

            int cantidadPrimos = contarPrimos(esPrimo);
            return crearVectorPrimos(esPrimo, cantidadPrimos);
        } else {
            return new int[0];
        }
    }

    /**
     * Inicializa un vector booleano para indicar si un número es primo o no.
     *
     * @param esPrimo un vector booleano para indicar si un número es primo o no
     */
    private static void inicializarVectorPrimos(boolean[] esPrimo) {
        for (int i=2; i< esPrimo.length; i++)
            esPrimo[i] = true;
    }

    /**
     * Busca números primos utilizando el algoritmo de la criba de Eratóstenes.
     *
     * @param esPrimo un vector booleano que indica si un número es primo o no
     */
    private static void buscarPrimos(boolean[] esPrimo) {
        for (int i=2; i<Math.sqrt(esPrimo.length)+1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplosDelIesimo(esPrimo, i);
            }
        }
    }

    /**
     * Elimina los múltiplos de un número en un vector booleano.
     *
     * @param esPrimo un vector booleano que indica si un número es primo o no
     * @param i el número del cual se eliminarán los múltiplos
     */
    private static void eliminarMultiplosDelIesimo(boolean[] esPrimo, int i) {
        for (int j=2*i; j<esPrimo.length; j+=i)
            esPrimo[j] = false;
    }

    private static int contarPrimos(boolean[] esPrimo) {
        int cantidadTotalPrimos = 0;

        for (int i=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                cantidadTotalPrimos++;
        }
        return cantidadTotalPrimos;
    }

    private static int[] crearVectorPrimos(boolean[] esPrimo, int cantidadPrimos) {
        int[] primos = new int[cantidadPrimos];
        for (int i=0, j=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }



    public static void main(String[] args) {
        int numeroMaximo = obtenerEntradaUsuario();
        int vectorNumerosPrimos[]=new int[numeroMaximo];

        imprimirVectorInicial(numeroMaximo, vectorNumerosPrimos);
        vectorNumerosPrimos= generarPrimosHastaMax(numeroMaximo);

        imprimirVectorPrimos(numeroMaximo, vectorNumerosPrimos);
    }

    private static int obtenerEntradaUsuario() {
        Scanner teclado=new Scanner(System.in);
        String preguntaInicial = "Introduce el número para la criba de Erastótenes:";
        System.out.println(preguntaInicial);
        int numeroMaximo=teclado.nextInt();
        return numeroMaximo;
    }

    private static void imprimirVectorInicial(int numeroMaximo, int[] vectorTodosNumeros) {
        System.out.println("\nVector inicial hasta :"+ numeroMaximo);
        for (int i = 0; i < vectorTodosNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }

    private static void imprimirVectorPrimos(int numeroMaximo, int[] vectorNumeros) {
        System.out.println("\nVector de primos hasta:"+ numeroMaximo);
        for (int i = 0; i < vectorNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vectorNumeros[i]+"\t");
        }
    }
}
