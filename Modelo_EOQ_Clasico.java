import java.util.Scanner;
public class Modelo_EOQ_Clasico{
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        System.out.println("Ingrese la demanda del producto: ");
        int d = lec.nextInt();
        System.out.println("Ingrese el costo de la demanda: ");
        int k = lec.nextInt();
        System.out.println("Ingrese el costo de almacen del producto: ");
        double h = lec.nextInt();
        int y = 0;
        double resultado = Operaciones(d,k,h, y);
        double entrega = Tiempo(y, d);
        System.out.println("El tamaño optimo del pedido es: " + resultado);
        System.out.println("El tiempo entre pedidos es: " + entrega);
    }
    public static double Operaciones(int d, int k, double h, int y){
        return y = (int) Math.sqrt(2*k*d/h);
    }
    public static double Tiempo(int y, int d){
        return (y/d);
    }
}