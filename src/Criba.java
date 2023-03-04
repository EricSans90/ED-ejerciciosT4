import java.util.Scanner;

public class Criba
{
    public static int[] generarPrimosHastaMax(int numeroMAX)
    {
        if (numeroMAX >= 2) {
            // Declaraciones
            int TamañoArray = numeroMAX + 1;
            boolean[] esPrimo = new boolean[TamañoArray];
            inicializarVectorPrimos(TamañoArray, esPrimo);
            buscarPrimos(TamañoArray, esPrimo);
            int cantidadPrimos = contarPrimos(TamañoArray, esPrimo);
            return crearVectorPrimos(TamañoArray, esPrimo, cantidadPrimos);
        } else {
            // Vector vacío
            return new int[0];
        }
    }

    private static int[] crearVectorPrimos(int TamañoArray, boolean[] esPrimo, int cantidadPrimos) {
        int j;
        int i;
        int[] primos = new int[cantidadPrimos];
        for (i=0, j=0; i< TamañoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int contarPrimos(int TamañoArray, boolean[] esPrimo) {
        int i;
        int cantidadTotalPrimos = 0;
        for (i=0; i< TamañoArray; i++) {
            if (esPrimo[i])
                cantidadTotalPrimos++;
        }
        return cantidadTotalPrimos;
    }

    private static void inicializarVectorPrimos(int TamañoArray, boolean[] esPrimo) {
        int i;
        for (i=0; i< TamañoArray; i++)
            esPrimo[i] = true;
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
    }

    private static void buscarPrimos(int TamañoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(TamañoArray)+1; i++) {
            if (esPrimo[i]) {
                eliminarMultiplosI(TamañoArray, esPrimo, i);
            }
        }
    }

    private static void eliminarMultiplosI(int TamañoArray, boolean[] esPrimo, int i) {
        int j;
        for (j=2* i; j< TamañoArray; j+= i)
            esPrimo[j] = false;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String preguntaInicial = "Introduce el número para la criba de Erastótenes:";
        System.out.println(preguntaInicial);
        int numeroMaximo=teclado.nextInt();
        int vectorTodosNumeros[]=new int[numeroMaximo];
        imprimirVector10en10(numeroMaximo, vectorTodosNumeros);
        vectorTodosNumeros= generarPrimosHastaMax(numeroMaximo);
        System.out.println("\nVector de primos hasta:"+numeroMaximo);
        for (int i = 0; i < vectorTodosNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vectorTodosNumeros[i]+"\t");
        }
    }

    private static void imprimirVector10en10(int numeroMaximo, int[] vectorTodosNumeros) {
        System.out.println("\nVector inicial hasta :"+ numeroMaximo);
        for (int i = 0; i < vectorTodosNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }
}
