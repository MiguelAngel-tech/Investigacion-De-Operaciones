import java.util.Scanner;
public class Modelo_EOQ_Clasico{
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        System.out.println("");
        System.out.println("Ingrese la demanda del producto: ");
        double d = lec.nextDouble();
        System.out.println("Ingrese el costo de la demanda: ");
        double k = lec.nextDouble();
        System.out.println("Ingrese el costo de almacen del producto: ");
        double h = lec.nextDouble();
        System.out.println("Ingrese el tiempo de entrega: ");
        double l = lec.nextDouble();
        double y = 0;
        float le = 0;
        double resultado = Operaciones(d,k,h, y);
        double entrega = Tiempo(resultado, d);
        int n = (int)(l/entrega);
        double ptoReorden = PDR(entrega, l, n, le, d);
        System.out.println();
        System.out.println("El tamaño optimo del pedido es: " + resultado);
        System.out.println("El tiempo entre pedidos es: " + entrega);
        System.out.println("");
        System.out.println("Punto de reorden");
        System.out.println("");
        System.out.println("El punto de reorden es: " + ptoReorden);

    }
    public static double Operaciones(double d, double k, double h, double y){
        return y = Math.sqrt(2*k*d/h);
    }
    public static double Tiempo(double y, double d){
        return (y/d);
    }
    public static double PDR(double entrega, double l, int n, double le, double d){
        le = l - (n*entrega);
        return le * d;
    }
}