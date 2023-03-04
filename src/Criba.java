import java.util.Scanner;

public class Criba
{
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

    private static void inicializarVectorPrimos(boolean[] esPrimo) {
        for (int i=2; i< esPrimo.length; i++)
            esPrimo[i] = true;
    }

    private static void buscarPrimos(boolean[] esPrimo) {
        for (int i=2; i<Math.sqrt(esPrimo.length)+1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplosDeI(esPrimo.length, esPrimo, i);
            }
        }
    }

    private static void eliminarMultiplosDeI(int TamañoArray, boolean[] esPrimo, int i) {
        for (int j=2*i; j<TamañoArray; j+=i)
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
