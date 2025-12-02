import java.util.*;
import java.util.Scanner;
public class Vogel{
    public static void main(String[]args){
        Scanner lec = new Scanner(System.in);
        //le se pide al usuario la cantidad de ofertas y demandas, las ofertas y los costos
        System.out.println("\n \n \t \tMetodo de aproximacion de Vogel");
        System.out.println("\n \n \t \tLlenado de las ofertas");
        System.out.println("Ingrese la cantidad de ofertas: ");
        byte ofert = lec.nextByte();
        //arreglo para las ofertas
        int [] ofertas = new int[ofert];
        for(int i=0; i<ofert; i++){
            ofertas [i] = 0;
            System.out.println("Ingrese la oferta "+ (i+1));
            ofertas[i] = lec.nextInt();
        }
        //arreglo para las demandas
        System.out.println("\n \n \t \tLlenado de las demandas");
        System.out.println("Ingrese la cantidad de demandas: ");
        byte demand = lec.nextByte();
        int [] demandas = new int[demand];
        for(int i=0; i<demand; i++){
            System.out.println("Ingrese la demanda "+ (i+1));
            demandas[i] = lec.nextInt();
        }
        System.out.println("\n \n \t \tLlenado de los costos");
        //matriz para los costos
        int[][] costos = new int [ofert][demand];
        for(int i=0; i<ofert; i++){
            for(int j=0; j<demand; j++){
                System.out.println("Ingrese el costo de transportar la oferta "+ (i+1) + " a la demanda "+ (j+1));
                costos [i][j] = lec.nextInt();
            }
        }
        System.out.println("\n \n \t \tImpresion de la matriz de costos");
        //impresion de la matriz de costos
            // Imprimir encabezados de columna (ofertas)
            System.out.print("      ");
            for(int j = 0; j < ofert; j++) {
                System.out.printf("%d   ", ofertas[j]);
            }
            System.out.println();

            // Imprimir cada fila con la demanda y los costos
            for(int i = 0; i < demand; i++) {
                System.out.printf("D %d | ", demandas[i]);
                for(int j = 0; j < ofert; j++) {
                    System.out.printf("%-4d ", costos[j][i]);
                }
                System.out.println();
            }
    }
}
