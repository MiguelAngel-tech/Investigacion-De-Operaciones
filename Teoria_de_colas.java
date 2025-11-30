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
                    break;
                case 2:
                    //medelo m/m/2
                    break;
                case 3:
                    //modelo m/m/3
                    break;
                case 4:
                    break;
                    default:
                        System.out.println("Opcion invalida."); 

            }

        }while(opcion != 4);
    }
}
