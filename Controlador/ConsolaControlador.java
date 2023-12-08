package Controlador;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Modelo.Candidatos;
import Controlador.CandidatosControlador;
import Vista.ConsolaVista;

public class ConsolaControlador {
    
    public static void crear_candidato(Scanner scanner, List<Candidatos> candidatos) {
        ConsolaVista.presionarContinuar(scanner);
        Candidatos candidato = CandidatosControlador.datos_Candidatos(scanner);// crea un candidato
        candidatos.add(candidato);// lo añade a la lsita tipo candidatos
    }

    public static void actualizar_candidato(Scanner scanner,List<Candidatos> candidatos) {
        ConsolaVista.presionarContinuar(scanner);
        ConsolaVista.getString(scanner, "");
        String nombreABuscar = ConsolaVista.getString(scanner, "Ingrese el nombre del candidato que desea actualizar: ");
        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreABuscar)) {
                //System.out.println("Ingrese los nuevos datos del candidato:\n");
                candidato = CandidatosControlador.datos_Candidatos(scanner);// actualiza un candidato
            }
        }
        ConsolaVista.presionarContinuar(scanner);
        
    }
    public static void eliminar_candidato(Scanner scanner, List<Candidatos> candidatos) {
        ConsolaVista.presionarContinuar(scanner);
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
        ConsolaVista.presionarContinuar(scanner);
    }
    public static void buscar_candidato(Scanner scanner, List<Candidatos> candidatos){
        ConsolaVista.presionarContinuar(scanner);
        ConsolaVista.getString(scanner, "");
        String nombreBuscado = ConsolaVista.getString(scanner, "Ingrese el nombre del candidato que desea buscar: ");
        if (!CandidatosControlador.buscarCandidatosPorNombre(candidatos, scanner, nombreBuscado)){
            System.out.println("Candidato " + nombreBuscado + " no encontrado en la lista.");
        }
        ConsolaVista.presionarContinuar(scanner);
    }
    public static void listar_candidatos(Scanner scanner, List<Candidatos> candidatos){
        ConsolaVista.presionarContinuar(scanner);
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            ConsolaVista.print_candidato_object(candidato);
             // Devuelve el candidato por cada candidato
        }
        ConsolaVista.presionarContinuar(scanner);
    }
}
