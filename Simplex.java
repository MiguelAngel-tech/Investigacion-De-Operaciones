import java.util.Scanner;
public class Simples{
    //Atributos 
    private double [][] tabla; //Tabla simples
    private int numVariables; //Numero de variables 
    private int numRestricciones; //Numero de restricciones
    private int numVariablesTotales; //Variables mas los de holgura
    private boolean esMaximizacion;
    private int variablesBasicas; 
    private String [] nombresVariables;
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== MÉTODO SIMPLEX ===");// Titulo
        System.out.println("¿Es maximización (1) o minimización (2)?: ");//Seleccion de operacion a realizar
        int tipo = scanner.nextInt();
        boolean esMaximizacion = (tipo == 1);
        System.out.println("Número de variables de decisión (x1, x2, ...): ");//Numero de varaibles
        int numVariables = scanner.nextInt();
        System.out.println("Numero de restricciones: ");//cantidad de restricciones
        int numRestricciones = scanner.nextInt();
        Simplex simplex = new Simplex(numVariables, numRestricciones, esMaximizacion);
        simplex.ingresaDatos(scanner);
        simplex.resolver();
        simplex.close();
    }
    public Simplex(int numVariables, int numRestricciones, boolean esMaximizacion){
        this.numVariables = numVariables;
        this.numRestricciones = numRestricciones;
        this.esMaximizacion = esMaximizacion;
        this.numVariablesTotales = numVariables + numRestricciones; 
        this.variablesBasicas = new int[numRestricciones];
        this.nombresVariables = new String[numVariablesTotales];
        //Iniciar nombre de variables
        for(int i=0; i<numVariables; i++){
            nombresVariables[i] = "x " + (i+1);
        }
        for(int i=0; i<numRestricciones; i++){
            nombresVariables[numVariables + i] = "s" + (i+1);
        }
        // Inicializar tabla simplex
        tabla = new double[numRestricciones + 1][numVariablesTotales + 1];
    }
}
