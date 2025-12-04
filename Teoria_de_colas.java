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
                    System.out.println("Utilizacion del sistema: " + utilizacion);
                    float p0 = (float)(1-utilizacion)/(float)(1-(Math.pow(utilizacion, k+1)));
                    System.out.println("Probabilidad de 0 clientes en el sistema: " + (p0 * 100f));
                    //probabilidad de rechazo
                    float pk = (float)(Math.pow(utilizacion, k)) * (p0);
                    System.out.println("La probabilidad de rechazo es de: " + (pk * 100f));
                    //tasa de llegada
                    float tasaLlegada = (lambda2 * 1)-pk;
                    System.out.println("La tasa de llegada es: " + tasaLlegada);
                    //longitud promedio de la cola
                    float l = (float) (utilizacion * (1-(k+1) * (Math.pow(utilizacion, k)) + k * (Math.pow(utilizacion, k+1)))/(1-utilizacion)*(1-(Math.pow(utilizacion, k + 1))));
                    System.out.println("La longitud promedio de la cola es de: " + l);
                    //tiempo promedio del sistema
                    float w = l/tasaLlegada;
                    System.out.println("El tiempo promedio del sistema es: " + w);
                case 3:
                    //modelo m/m/c
                    System.out.printnln("Ingrese el numero de servidores: ");
                    int c = lec.nextInt();
                    System.out.printnln("Ingrese la tasa de llegada: ");
                    float lambda3 = lec.nextFloat();
                    System.out.printnln("Ingrese la tasa de servicio por servidor: ");
                    float miu3 = lec.nextFloat();
                    //metodo para mmc
                    modeloMMC(c,lambda3,miu3);
                    break;
                case 4:
                    //salir del programa
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
    public static long factorial(int n){
        long fact = 1;
        for(int i = 2; i <= n; i++){
            fact *= i; 
        }
        return fact;
    }
    public static void modeloMMC(int c, float lambda3, float miu3){
        float rho = lambda3 / (c * miu3);
        float a = lambda3 / miu3;
        System.out.printnln("La carga total por servidor es de: " + a);
        System.out.printnln("La utilizacion por servidor es de: " + (rho * 100) + " %");
        //probabilidad de 0 clientes 
        float sumatoria = 0;
        for(int n = 0; n < c; n++){
            sumatoria += Math.pow(a,n) / factorial(n);
        }
        sumatoria += Math.pow(a,c) / (factorial(c) * (1 - rho));
        float p0 = 1 / sumatoria;
        System.out.printnln("La probabilidad de 0 clientes en el sistema es de: " + (p0 * 100) + " %");
        //P_espera
        float P_espera = (float)(Math.pow(a,c) * p0 / (factorial(c) * (1 - rho)));
        System.out.printnln("La probabilidad de espera es de: " + (P_espera * 100) + " %");
        //promedio en la cola
        float lq = (P_espera * rho) / (1 - rho);
        System.out.println("Promedio en la cola: " + lq + " clientes");
        //tiempo de espera
        float wq = lq / lambda3 * 60;
        System.out.printnln("Tiempo promedio de espera en la cola: " + wq + " min");
        //longitud de la cola
        float l2 = lq + a;
        System.out.println("La longitud de la cola es de: " + l2 + " clientes");
        //tiempo promedio en el sistema
        float w2 = wq + (1 / miu3) * 60;
        System.out.printnln("Tiempo total en el sistema: "+ w2 + " min");   
    }
}//public class
