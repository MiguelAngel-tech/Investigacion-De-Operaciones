import java.util.Scanner;
public class Teoria_de_colas {
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        byte opcion = 0;
        do{
            System.out.println("\n \n \t--Menu de teoria de colas--");
            System.out.println("1. Modelo M/M/1.");
            System.out.println("2. Modelo M/M/1/k.");
            System.out.println("3. Modelo M/M/3.");
            System.out.println("4. Salir.");
            opcion = lec.nextByte();
            switch(opcion){
                case 1:
                    //modelo m/m/1
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    int lambda = lec.nextInt();
                    System.out.println("Ingrese la tasa de servicio (μ): ");
                    int miu = lec.nextInt();
                    //utilizacion del sistema
                    float promedio = utilizacionDeSistema(lambda, miu);
                    System.out.println("La utilizacion del sistema es del: " + promedio + " %");
                    //numero promedio de clientes en el sistema
                    float promedioClientes = promedioDeClientes(lambda, miu);
                    System.out.println("Número promedio de clientes en el sistema: " + promedioClientes);
                    //tiempo promedio de espera en la cola
                    float promedioDeEspera = promedioEspera(promedioClientes,lambda);
                    System.out.println("Tiempo promedio de espera en la cooa: " + promedioDeEspera + " minutos");
                    //tiempo total en el sistema
                    float tiempoTotal = promedioDeEspera + (1f/miu) * 60f;
                    System.out.println("El tiempo total en el sistema es de: " + tiempoTotal + " minutos ó " + (tiempoTotal/60f) + " horas");
                    break;
                case 2:
                    //medelo m/m/1/k
                    break;
                case 3:
                    //modelo m/m/3
                    break;
                case 4:
                    //salir del programa
                    for(int i = 5; i >= 0; i--){
                        System.out.println(i);
                    } 
                    break;
                    default:
                        System.out.println("Opcion invalida."); 

            }//switch

        }while(opcion != 4);
    } //main
    public static float utilizacionDeSistema(int lambda, int miu){
        float utilizacion = 0;
        utilizacion = (float)(lambda) / (float)(miu);
        return utilizacion * 100f;
    }
    public static float promedioDeClientes(int lambda, int miu){
        float lq = 0;
        lq = (float)Math.pow(lambda,2) / (miu * (miu - lambda));
        return lq;
    }
    public static float promedioEspera(float lq, int lambda){
        float wq = 0;
        wq = lq / lambda;
        return wq * 60f;//pasarlo a minutos
    }
}//public class
