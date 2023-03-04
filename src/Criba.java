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
        int cuenta = 0;
        for (i=0; i< TamañoArray; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
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
                // Eliminar los múltiplos de i
                for (j=2*i; j< TamañoArray; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector= generarPrimosHastaMax(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
