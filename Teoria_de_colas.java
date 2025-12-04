import java.util.Scanner;
public class Teoria_de_colas {
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        byte opcion = 0;
        do{
            System.out.println("\n \n \t--Menu de teoria de colas--");
            System.out.println("1. Modelo M/M/1.");
            System.out.println("2. Modelo M/M/1/k.");
            System.out.println("3. Modelo M/M/c.");
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
                    System.out.println("Ingrese la tasa de llegada o pedidos: ");
                    int pedidos = lec.nextInt();
                    System.out.println("Ingrese el horario de atencion: ");
                    int hora = lec.nextInt();
                    float miu2 = (float)(pedidos)/(float)(hora);
                    System.out.println("Ingrese la tasa de llegada: ");
                    int lambda2 = lec.nextInt();
                    System.out.println("ingrese la capacidad maxima del sistema: ");
                    int k = lec.nextInt();
                    float utilizacion = lambda2 / miu2;
                    System.out.println("Utilizacion del sistema: " + rho);
                    float p0 = (1-utilizacion)/(1-(Math.pow(utilizacion, k+1)));
                    System.out.println("Probabilidad de 0 clientes en el sistema: " + (p0 * 100f));
                    //probabilidad de rechazo
                    float pk = Math.pow(utilizacion, k) * (p0);
                    System.out.println("La probabilidad de rechazo es de: " + (pk * 100f));
                    //tasa de llegada
                    float tasaLlegada = (lambda2 * 1)-pk;
                    System.out.println("La tasa de llegada es: " + tasaLlegada);
                    //longitud promedio de la cola
                    float l = (utilizacion(1-(k+1) * (Math.pow(utilizacion, k)) + k * (Math.pow(utilizacion, k+1)))/(1-utilizacion)*(1-(Math.pow(utilizacion, k + 1))));
                    System.out.println("La longitud promedio de la cola es de: " + l);
                    //tiempo promedio del sistema
                    float w = l/tasaLlegada;
                    System.out.println("El tiempo promedio del sistema es: " + w);
                    break;
                case 3:
                    //modelo m/m/c
                    break;
                case 4:
                    //salir del programa
                    for(int i = 5; i >= 0; i--){
                        System.out.print(i);
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
    public static float erlang(int lamnda2, int miu1){
        float a = 0;
        a = (float)(lamnda2)/ (float) miu2;
        return a;
    }
}//public class
