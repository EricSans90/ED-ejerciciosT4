import java.util.Scanner;
/**
 * Clase CribarPrimos:
 * Generar un vector de números primos utilizando el algoritmo de la criba de Eratóstenes hasta un número
 * introducido por el usuario.
 * @author Eric Sans
 * @version 1.0
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
    public static void inicializarVectorPrimos(boolean[] esPrimo) {
        for (int i=2; i< esPrimo.length; i++)
            esPrimo[i] = true;
    }

    /**
     * Busca números primos utilizando el algoritmo de la criba de Eratóstenes.
     *
     * @param esPrimo un vector booleano que indica si un número es primo o no
     */
    public static void buscarPrimos(boolean[] esPrimo) {
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
    public static void eliminarMultiplosDelIesimo(boolean[] esPrimo, int i) {
        for (int j=2*i; j<esPrimo.length; j+=i)
            esPrimo[j] = false;
    }

    /**
     * Cuenta la cantidad de números primos en un vector booleano.
     *
     * @param esPrimo un vector booleano que indica si un número es primo o no
     * @return la cantidad de números primos en el vector booleano
     */
    public static int contarPrimos(boolean[] esPrimo) {
        int cantidadTotalPrimos = 0;

        for (int i=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                cantidadTotalPrimos++;
        }
        return cantidadTotalPrimos;
    }

    /**
     * Crea un vector de números primos a partir de un vector booleano que indica si un número es primo o no.
     *
     * @param esPrimo un vector booleano que indica si un número es primo o no
     * @param cantidadPrimos la cantidad de números primos en el vector booleano
     * @return un vector de números primos
     */
    public static int[] crearVectorPrimos(boolean[] esPrimo, int cantidadPrimos) {
        int[] primos = new int[cantidadPrimos];
        for (int i=0, j=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Método principal que lee un número del usuario y genera un vector de números primos hasta ese número.
     *
     * @param args los argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        int numeroMaximo = obtenerEntradaUsuario();
        int vectorNumerosPrimos[]=new int[numeroMaximo];

        imprimirVectorInicial(numeroMaximo, vectorNumerosPrimos);
        vectorNumerosPrimos= generarPrimosHastaMax(numeroMaximo);

        imprimirVectorPrimos(numeroMaximo, vectorNumerosPrimos);
    }

    /**
     * Obtiene un número del usuario utilizando la entrada estándar.
     *
     * @return el número introducido por el usuario
     */
    public static int obtenerEntradaUsuario() {
        Scanner teclado=new Scanner(System.in);
        String preguntaInicial = "Introduce el número para la criba de Erastótenes:";
        System.out.println(preguntaInicial);
        int numeroMaximo=teclado.nextInt();
        return numeroMaximo;
    }

    /**
     * Imprime por consola el vector inicial de números hasta el número máximo dado.
     *
     * @param numeroMaximo El número máximo hasta el que imprimir el vector.
     * @param vectorTodosNumeros El vector de todos los números.
     */
    public static void imprimirVectorInicial(int numeroMaximo, int[] vectorTodosNumeros) {
        System.out.println("\nVector inicial hasta :"+ numeroMaximo);
        for (int i = 0; i < vectorTodosNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }

    /**
     * Imprime por consola el vector de números primos hasta el número máximo dado.
     *
     * @param numeroMaximo El número máximo hasta el que imprimir el vector de primos.
     * @param vectorNumeros El vector de números primos.
     */
    public static void imprimirVectorPrimos(int numeroMaximo, int[] vectorNumeros) {
        System.out.println("\nVector de primos hasta:"+ numeroMaximo);
        for (int i = 0; i < vectorNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vectorNumeros[i]+"\t");
        }
    }
}
