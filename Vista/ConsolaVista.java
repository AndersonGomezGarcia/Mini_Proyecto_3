package Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Modelo.Candidatos;
import Modelo.Ciudadano;
import Controlador.CandidatosControlador;
import Controlador.ConsolaControlador;
import Controlador.CandidatosControlador.derecha;


public class ConsolaVista extends Ciudadano {

    public ConsolaVista(){
        main(args);
    }
    private static List<Candidatos> candidatos = new ArrayList<>();
    private static boolean a;
    public static void presionarContinuar(Scanner scanner) {
        System.out.println("\nPresiona enter para continuar...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {
        }
        System.out.print("\033[H\033[2J");  
    System.out.flush(); 
    }

    public static String getString(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public static String seleccionar_Ciudad_Origen(Scanner scanner) {
        System.out.println("\nPor favor elige una ciudad entre las siguientes");
        for (CandidatosControlador.Ciudades city : CandidatosControlador.Ciudades.values()) {
            System.out.println(city.ordinal() + ". " + city);
        }
        while (true) {
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion < CandidatosControlador.Ciudades.values().length) {
                System.out.println("\nHas seleccionado a " + CandidatosControlador.Ciudades.values()[opcion] + " como ciudad de origen");
                return (CandidatosControlador.Ciudades.values()[opcion]).toString();
            }
            System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
        }
    }

    public static int Votos( Scanner scanner, String nombre, String cedula) {
        while (true) {
            try {   
                System.out.print("\nIngrese el número de votos para " + nombre + " con cedula ("+cedula+"): ");
                int votos = Integer.parseInt(scanner.next());
                if (votos >= 0) {
                    return votos; // Salir del bucle si el valor es válido y retornar votos
                } else {
                    System.out.println("El número de votos debe ser un valor no negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                scanner.next(); // Limpiar el búfer del scanner para evitar un bucle infinito
            }
        }
    }

    public static boolean seleccionar_Orientacion_Politica(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Selecciona tu orientación política:");
            System.out.println("1. Derecha");
            System.out.println("2. Izquierda");
            System.out.print("Ingresa el número de la opción (1 o 2): ");
            opcion = scanner.nextInt();

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
            }
        } while (opcion != 1 && opcion != 2);
        boolean esDerecha = (opcion == 1);// comprueba si eligio derecha y retorna false o true
        return esDerecha;
    }

    public static String seleccionar_Partido_Politico(Scanner scanner, boolean Derecha) {
        if (Derecha) {
                System.out.println("\nPor favor elige una partido de Derecha entre los siguientes");
        for (CandidatosControlador.derecha partido : CandidatosControlador.derecha.values()) {
                System.out.println(partido.ordinal() + ". " + partido);
            }
            while (true) {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < CandidatosControlador.derecha.values().length) {
                    System.out.println("\nHas seleccionado a " + CandidatosControlador.derecha.values()[opcion] + " como partido de Derecha");
                    return (CandidatosControlador.derecha.values()[opcion]).toString();
                }
                System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
            }
        }else{ 

            System.out.println("\nPor favor elige un partido de Izquierda entre las siguientes");
        for (CandidatosControlador.izquierda partido : CandidatosControlador.izquierda.values()) {
                System.out.println(partido.ordinal() + ". " + partido);
            }
            do{
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < CandidatosControlador.izquierda.values().length) {
                    System.out.println("\nHas seleccionado a " + CandidatosControlador.izquierda.values()[opcion] + " como partido de Izquierda");
                    return (CandidatosControlador.izquierda.values()[opcion]).toString();
                }
                System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
            }while(true);
        }
    }
    public static String crear_Lista_Promesas(Scanner scanner) {
        List<String> promesasList = new ArrayList<>(); 
        System.out.println("Ingrese las promesas del candidato (escriba 'fin' para finalizar):");
        while (true) {
            System.out.print("Promesa: ");
            String promesa = scanner.nextLine();

            if (promesa.equalsIgnoreCase("fin")) {
                break; // Terminar la entrada cuando se escriba 'fin'.
            }
            promesasList.add(promesa); // Agregar la promesa a la lista.
        }
        // Construir un String con las promesas separadas por '\n'
        StringBuilder promesasString = new StringBuilder();
        for (String promesa : promesasList) {
            promesasString.append(promesa).append("\n|| Promesa de campaña:");
        }
        return promesasString.toString();
    }

    public static void print_candidato(String nombre, String cedula, String ciudad, boolean orientacion, String partido,String promesas){
        String orientacion_politica;
        if (orientacion){
            orientacion_politica = "Derecha";
        }else {orientacion_politica = "Izquierda";}
        System.out.print("\n\n==============================\n||Candidato\n|| Nombre: "+nombre+"\n|| Cedula: "+cedula+"\n|| Ciudad: "+ ciudad +"\n|| Orientacio Politica: "+ orientacion_politica+"\n|| Partido politico: "+partido+"\n|| Promesas de campaña: "+ promesas );
    }

    public static void print_candidato_object(Candidatos candidato){
        print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(),candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());
    }

    
    
    public static void buscar_candidato(Scanner scanner, List<Candidatos> candidatos){
        String nombreBuscado = getString(scanner, "Ingrese el nombre del candidato que desea buscar: ");
        if (!CandidatosControlador.buscarCandidatosPorNombre(candidatos, scanner, nombreBuscado)){
            System.out.println("Candidato " + nombreBuscado + " no encontrado en la lista.");
        }
    }

    public static void listar_candidatos(Scanner scanner, List<Candidatos> candidatos){
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            print_candidato_object(candidato); // Devuelve el candidato por cada candidato
        }
    }
    public static void votos_candidatos(Scanner scanner, List<Candidatos> candidatos){
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            print_candidato_object(candidato); // Devuelve el candidato por cada candidato
            candidato.setNumero_votos(Votos(scanner, candidato.getNombre(),candidato.getCedula()));
        }
    }
    
    public static void candidato_ganador(List<Candidatos> candidatos){
        Candidatos candidato = CandidatosControlador.encontrarGanador(candidatos);
        System.out.print("||| El candidato ganador ha sido:   |||\n");
        print_candidato_object(candidato);
    }

    public static String encontrarPartidoConMasCandidatos(List<Candidatos> candidatos) {
        // Crear un mapa para mantener la cuenta de candidatos por partido
        Map<String, Integer> conteoPartidos = new HashMap<>();

        // Iterar a través de la lista de candidatos
        for (Candidatos candidato : candidatos) {
            String partido = candidato.getPartido_politico();
            conteoPartidos.put(partido, conteoPartidos.getOrDefault(partido, 0) + 1);
        }

        // Encontrar el partido con la mayor cantidad de candidatos inscritos
        String partidoGanador = null;
        int cantidadMaxima = 0;

        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            if (entry.getValue() > cantidadMaxima) {
                partidoGanador = entry.getKey();
                cantidadMaxima = entry.getValue();
            }
        }
        System.out.println("\nEl partido con más candidatos inscritos es: " + partidoGanador);
        return partidoGanador;
        
    }
    public static List<String> top3CiudadesConMenosCandidatos(List<Candidatos> candidatos) {
        
        Map<String, Integer> conteoCiudades = new HashMap<>();// Crear un mapa para mantener el conteo de candidatos por ciudad de orige
        
        for (Candidatos candidato : candidatos) {// Iterar a través de la lista de candidatos
            String ciudadOrigen = candidato.getCiudad_origen();
            conteoCiudades.put(ciudadOrigen, conteoCiudades.getOrDefault(ciudadOrigen, 0) + 1);
        }

        List<Map.Entry<String, Integer>> listaCiudadesOrdenada = new ArrayList<>(conteoCiudades.entrySet());// Crear una lista de ciudades ordenada por la cantidad de candidatos (ascendente)
        listaCiudadesOrdenada.sort(Map.Entry.comparingByValue());

        
        List<String> top3Ciudades = new ArrayList<>();// Obtener las tres ciudades con menos candidatos
        int contador = 0;

        for (Map.Entry<String, Integer> entrada : listaCiudadesOrdenada) {
            if (contador < 3) {
                top3Ciudades.add(entrada.getKey());
                contador++;
            } else {
                break;
            }
        }
        System.out.print("\n||| Las ciudades top 3 con menos candidatos de menor a mayor han sido   |||\n"+ top3Ciudades);
        return top3Ciudades;
    }

    public static void eliminar_candidato(Scanner scanner, List<Candidatos> candidatos) {

        System.out.print("Ingrese el nombre del candidato que desea eliminar: ");
        String nombre =  scanner.next();
        // Itera sobre la lista de candidatos y busca el candidato por su nombre
        Iterator<Candidatos> iterator = candidatos.iterator();
        while (iterator.hasNext()) {
            Candidatos candidato = iterator.next();
            if (candidato.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove(); // Elimina el candidato encontrado de la lista
                System.out.println("Candidato " + nombre + " eliminado con éxito.");
                return; // Sal del bucle si el candidato fue encontrado y eliminado
            }
        }
        System.out.println("Candidato " + nombre + " no encontrado en la lista.");
    }

    public static void main(Scanner scanner) {

        int opcion = 0;
        do {
            System.out.println("\n\n--------------------Bienvenido usuario------------------------");
            System.out.println("Qué desea hacer?");
            System.out.println("1. Insertar candidato");
            System.out.println("2. Actualizar candidato");
            System.out.println("3. Eliminar candidato");
            System.out.println("4. Buscar candidato por nombre");
            System.out.println("5. Listas todos los candidatos");
            System.out.print("elija una opcion: ");

            try {
                opcion = scanner.nextInt();
                System.out.println("Opción seleccionada: " + opcion);
            } catch (Exception e) {
                System.out.println("Error al leer la opción. Detalles: " + e.getMessage());
            }
            switch (opcion) {
                case 1:
                    ConsolaControlador.crear_candidato(scanner, candidatos);
                    break;
                case 2:
                    ;
                    ConsolaControlador.actualizar_candidato(scanner, candidatos);
                    break;
                case 3:
                    ;
                    ConsolaControlador.eliminar_candidato(scanner, candidatos);
                    break;
                case 4:
                    ;
                    ConsolaControlador.buscar_candidato(scanner, candidatos);
                    break;
                case 5:
                    ;
                    ConsolaControlador.listar_candidatos(scanner, candidatos);
                    break;
                case 0:
                    votos_candidatos(scanner,  candidatos);
                    candidato_ganador(candidatos);
                    encontrarPartidoConMasCandidatos(candidatos);
                    top3CiudadesConMenosCandidatos(candidatos);
                    break;
            }
        } while (opcion != 0);
    }
}
