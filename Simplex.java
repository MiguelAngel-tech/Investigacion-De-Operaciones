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
    //se crea el metodo para ingresar los datos
    public void ingresaDatos(Scanner sacnner){
        System.out.println("\n=== INGRESO DE LA FUNCIÓN OBJETIVO ===");
        System.out.println("Ingrese los coeficientes de la función objetivo:");
        // Ingresar coeficientes de la función objetivo para variables de decisión
        for (int j = 0; j < numVariables; j++) {
            System.out.printf("Coeficiente de x%d: ", j + 1);
            double coeficiente = scanner.nextDouble();
            if (esMaximizacion) {
                tabla[numRestricciones][j] = -coeficiente; // Maximización: Z positiva, demás negativos
            } else {
                tabla[numRestricciones][j] = coeficiente; // Minimización: Z negativa, demás positivos
            }
        }
        // Coeficientes de las variables de holgura en la función objetivo = 1
        for (int j = numVariables; j < numVariablesTotales; j++) {
            tabla[numRestricciones][j] = 1.0;
        }
        System.out.println("\n=== INGRESO DE RESTRICCIONES ===");
        for (int i = 0; i < numRestricciones; i++) {
            System.out.printf("\n--- Restricción %d ---\n", i + 1);
            // Coeficientes de las variables de decisión
            for (int j = 0; j < numVariables; j++) {
                System.out.printf("Coeficiente de x%d: ", j + 1);
                tabla[i][j] = scanner.nextDouble();
            }
            // Coeficientes de las variables de holgura
            for (int j = numVariables; j < numVariablesTotales; j++) {
                tabla[i][j] = (j == numVariables + i) ? 1.0 : 0.0;
            }
            // Lado derecho (LD)
            System.out.print("Lado derecho (LD) de la restricción: ");
            tabla[i][numVariablesTotales] = scanner.nextDouble();
            variablesBasicas[i] = numVariables + i; // Variable de holgura básica inicial
        }
        // Mostrar tabla inicial
        System.out.println("\n=== TABLA INICIAL SIMPLEX ===");
        imprimirTabla();
    }
    
}
