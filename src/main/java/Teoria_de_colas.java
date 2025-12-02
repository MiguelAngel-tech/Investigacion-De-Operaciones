import java.util.Scanner;
public class Teoria_de_colas {
    public static void main(String []args){
        Scanner lec = new Scanner(System.in);
        byte opcion = 0;
        do{
            System.out.println("\n \n \t--Menu de teoria de colas--");
            System.out.println("1. Modelo M/M/1.");
            System.out.println("2. Modelo M/M/2.");
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
                    System.out.println("La utilizacion del sistema es del: " + promedio + "%");
                    break;
                case 2:
                    //medelo m/m/1/k
                    break;
                case 3:
                    //modelo m/m/3
                    break;
                case 4:
                    
                    break;
                    default:
                        System.out.println("Opcion invalida."); 

            }//switch

        }while(opcion != 4);
    } //main
    public static float utilizacionDeSistema(int lambda, int miu){
        if (miu == 0) {
            throw new IllegalArgumentException("La tasa de servicio (μ) no puede ser 0.");
        }
        // Evitar división entera: castear a float antes de dividir.
        // Devolvemos porcentaje (0-100) en lugar de fracción (0-1).
        return ((float) lambda / (float) miu) * 100f;
    }
}//public class
