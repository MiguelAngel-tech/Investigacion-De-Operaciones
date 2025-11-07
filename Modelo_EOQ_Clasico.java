import java.util.Scanner;
public class Modelo_EOQ_Clasico{
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        System.out.println("Ingrese la demanda del producto: ");
        double d = lec.nextDouble();
        System.out.println("Ingrese el costo de la demanda: ");
        double k = lec.nextDouble();
        System.out.println("Ingrese el costo de almacen del producto: ");
        double h = lec.nextDouble();
        double y = 0;
        double resultado = Operaciones(d,k,h, y);
        double entrega = Tiempo(resultado, d);
        System.out.println("El tamaño optimo del pedido es: " + resultado);
        System.out.println("El tiempo entre pedidos es: " + entrega);
    }
    public static double Operaciones(double d, double k, double h, double y){
        return y = Math.sqrt(2*k*d/h);
    }
    public static double Tiempo(double y, double d){
        return (y/d);
    }
}