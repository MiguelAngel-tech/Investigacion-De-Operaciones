import java.util.Scanner;
public class Modelo_EOQ_Clasico{
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        System.out.println("Ingrese la demanda del producto: ");
        int d = lec.nextInt();
        System.out.println("Ingrese el costo de la demanda: ");
        int k = lec.nextInt();
        System.out.println("Ingrese el costo de almacen del producto: ");
        int h = lec.nextInt();
        int y;
        double operaciones = op(d,k,h);
        double tiempo = to(y, d);
        System.out.println("El tamaño optimo del pedido es: " + operaciones);
        System.out.println("El tiempo entre pedidos es: " + tiempo);
    }
    public static double Op(int d, int k, int h, int y){
        return y = Math.sqrt((2*(k*d))/h);
    }
    public static double To(int y, int d){
        return (y/d);
    }
}