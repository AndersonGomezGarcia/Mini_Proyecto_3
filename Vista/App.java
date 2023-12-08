package Vista;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n--------------------Bienvenido usuario------------------------");
            System.out.println("Qué desea hacer?");
            System.out.println("1. Utilizar app por consola");
            System.out.println("2. Utilizar GUI por ventana");

            System.out.print("elija una opcion: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ConsolaVista.main(scanner);
                    
                    opcion = 0;
                    break;
                case 2:
                    GUI.main(args);
  
                    opcion = 0;
                    break;
            }
        } while (opcion != 0);
    }
    
}
