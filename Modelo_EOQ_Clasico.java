import java.util.Scanner;
public class Modelo_EOQ_Clasico{
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        System.out.println("");
        System.out.println("Ingrese la demanda del producto: ");
        int d = lec.nextInt();
        System.out.println("Ingrese el costo de la demanda: ");
        int k = lec.nextInt();
        System.out.println("Ingrese el costo de almacen del producto: ");
        float h = lec.nextFloat();
        System.out.println("Ingrese el tiempo de entrega: ");
        int l = lec.nextInt();
        float y = 0;
        int le = 0;
        int resultado = Operaciones(d,k,h, y);
        float entrega = Tiempo(resultado, d);
        int n = (int)(l/entrega);
        float ptoReorden = (float) PDR(entrega, l, n, le, d);
        System.out.println();
        System.out.println("El tamaño optimo del pedido es: " + resultado);
        System.out.println("El tiempo entre pedidos es: " + entrega);
        System.out.println("");
        System.out.println("Punto de reorden");
        System.out.println("");
        System.out.println("El punto de reorden es: " + ptoReorden);

    }
    public static int Operaciones(int d, int k, float h, float y){
        return (int) (y = (float) Math.sqrt((2*k*d)/h)+1);
    }
    public static float Tiempo(float resultado, int d){
        return (resultado/d);
    }
    public static double PDR(float entrega, int l, int n, float le, int d){
        le = l - (n*entrega);
        return le * d;
    }
}