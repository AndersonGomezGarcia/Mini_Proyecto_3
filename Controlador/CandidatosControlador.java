package Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import Vista.ConsolaVista;
import Modelo.Candidatos;

public class CandidatosControlador {
    /*public static List<Candidatos> generarListaCandidatos() {
        List<Candidatos> candidatos = new ArrayList<>();
        // Datos ficticios para generar candidatos
        String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Carlos", "Laura", "Diego", "Elena", "Luis", "Sofia", "Roberto", "Isabel", "Fernando", "Carmen", "Pablo", "Rosa", "Javier", "Silvia", "Miguel", "Adriana"};
        String[] cedulas = {"1234567890", "2345678901", "3456789012", "4567890123", "5678901234", "6789012345", "7890123456", "8901234567", "9012345678", "0123456789", "1122334455", "2233445566", "3344556677", "4455667788", "5566778899", "6677889900", "7788990011", "8899001122", "9900112233", "0011223344"};
        String[] ciudades = {"Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena", "Manizales", "Pereira", "Cúcuta", "Bucaramanga", "Villavicencio", "Pasto", "Ibagué", "Neiva", "Popayán", "Montería", "Santa Marta", "Valledupar", "Armenia", "Riohacha", "Quibdó"};
        boolean[] orientaciones = {true, false};
        String[] partidos = {"Partido A", "Partido B", "Partido C", "Partido D", "Partido E"};
        String[] listasPromesas = {"Promesa 1", "Promesa 2", "Promesa 3", "Promesa 4", "Promesa 5"};

        Random random = new Random();

        // Generar 20 candidatos con datos aleatorios
        for (int i = 0; i < 20; i++) {
            Candidatos candidato = new Candidatos(
                    nombres[random.nextInt(nombres.length)],
                    cedulas[random.nextInt(cedulas.length)],
                    ciudades[random.nextInt(ciudades.length)],
                    orientaciones[random.nextInt(orientaciones.length)],
                    partidos[random.nextInt(partidos.length)],
                    listasPromesas[random.nextInt(listasPromesas.length)],
                    random.nextInt(1000) // Número de votos aleatorio
            );
            candidatos.add(candidato);
        }
        return candidatos;
    } */
    public static Candidatos datos_Candidatos(Scanner scanner) {// Crear candidatos
        scanner.nextLine();
        String nombre = ConsolaVista.getString(scanner,"Ingrese el nombre del ciudadano: ");
        String cedula = ConsolaVista.getString(scanner, "Ingrese la cedula del ciudadano: ");
        String ciudad = ConsolaVista.seleccionar_Ciudad_Origen(scanner);
        boolean orientacion = ConsolaVista.seleccionar_Orientacion_Politica(scanner);
        String partido = ConsolaVista.seleccionar_Partido_Politico(scanner, orientacion);
        String promesas = ConsolaVista.crear_Lista_Promesas(scanner);// crea las promesas
        //int votos = Candidatos.Votos(scanner, nombre );
        Candidatos candidato = new Candidatos(nombre, cedula, ciudad,  orientacion, partido, promesas, 0);
        // inserta los valores
        ConsolaVista.print_candidato(nombre, cedula, ciudad, orientacion, partido, promesas);                                                                                       // un nuevo candidato
        return candidato;
    }

    public static boolean buscarCandidatosPorNombre(List<Candidatos> candidatos,Scanner scanner,String nombreBuscado){
        for (Candidatos candidato: candidatos){
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscado)) {
                ConsolaVista.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(), candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());return true;
            }
        }
        return false;
    }
    public static Candidatos encontrarGanador(List<Candidatos> candidatos) {
        if (candidatos.isEmpty()) {
            return null; // Devuelve null si no hay candidatos en la lista
        }
    
        Candidatos ganador = candidatos.get(0); // Supongamos que el primer candidato es el ganador inicialmente
    
        for (Candidatos candidato : candidatos) {
            if (candidato.getNumero_votos() > ganador.getNumero_votos()) {
                ganador = candidato; // Actualiza el ganador si el candidato actual tiene más votos
            }
        }
        return ganador;
    }
    public static Candidatos buscarCandidatosPorCedula(List<Candidatos> candidatos, String cedulaabuscar) {
        for (Candidatos candidato : candidatos) {
            if (candidato.getCedula().equalsIgnoreCase(cedulaabuscar)) {
                return candidato;
            }
        }return null;
    }
    public static void borrarPorCedula(String candidatoparaeliminar, List<Candidatos> candidatos){
        for (Candidatos candidato : candidatos){
            if (candidato.getCedula() == candidatoparaeliminar){
                candidatos.remove(candidato);
                break;
            }
        }
    }
    public static Candidatos determinarGanador(List<Candidatos> candidatos) {
        Candidatos ganador = null;
    
        for (Candidatos candidato : candidatos) {
            if (ganador == null || candidato.getNumero_votos() > ganador.getNumero_votos()) {
                ganador = candidato;
            }
        }
        return ganador;
    }
    public static String encontrarPartidoConMasCandidatos(List<Candidatos> candidatos) {
        //Crear un mapa para mantener la cuenta de candidatos por partido
        Map<String, Integer> conteoPartidos = new HashMap();
        
        for (Candidatos candidato : candidatos) {//Iterar a traves de la lista de candidatos
            String partido = candidato.getPartido_politico();
            conteoPartidos.put(partido, conteoPartidos.getOrDefault(partido, 0) + 1);
        }
        
        int cantidadMaxima = 0;//Encontrar la cantidad maxima de candidatos inscritos
        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            cantidadMaxima = Math.max(cantidadMaxima, entry.getValue());
        }
        
        List<String> partidosGanadores = new ArrayList<>();//Encontrar todos los partidos con la cantidad maxima de candidatos inscritos
        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            if (entry.getValue() == cantidadMaxima) {
                partidosGanadores.add(entry.getKey());
            }
        }
        
        String mensaje = "Los partidos con más candidatos inscritos son: " + partidosGanadores +
                " con un total de " + cantidadMaxima + " candidatos inscritos";
        return mensaje;
    }
    public static String[] ObtenerCedulas(List<Candidatos> candidatos){
        List<String> cedulas = new ArrayList<>();
        for (Candidatos candidato : candidatos) {
            cedulas.add(candidato.getCedula());
        }

        // Ahora puedes convertir la lista a un array si es necesario
        String[] arrayCedulas = cedulas.toArray(new String[0]);
        return arrayCedulas;
    }
    public static String top3CiudadesConMenosCandidatos(List<Candidatos> candidatos) {

        Map<String, Integer> conteoCiudades = new HashMap<>();//Crear un mapa para mantener el conteo de candidatos por
                                                              //ciudad de origen

        for (Candidatos candidato : candidatos) {//Iterar a traves de la lista de candidatos
            String ciudadOrigen = candidato.getCiudad_origen();
            conteoCiudades.put(ciudadOrigen, conteoCiudades.getOrDefault(ciudadOrigen, 0) + 1);
        }

        List<Map.Entry<String, Integer>> listaCiudadesOrdenada = new ArrayList<>(conteoCiudades.entrySet());//Crear unalista de   ciudades   ordenada    por la    cantidad    de   candidatos   (ascendente)
        listaCiudadesOrdenada.sort(Map.Entry.comparingByValue());

        List<String> top3Ciudades = new ArrayList<>();//Obtener las tres ciudades con menos candidatos
        int contador = 0;

        for (Map.Entry<String, Integer> entrada : listaCiudadesOrdenada) {
            if (contador < 3) {
                top3Ciudades.add(entrada.getKey());
                contador++;
            } else {
                break;
            }
        }
        String mensaje = "Las ciudades top 3 con menos candidatos de menor a mayor han sido:  "   + top3Ciudades;
        return mensaje;
    }

    public static enum derecha{Partido_Liberal_Colombiano, Partido_Conservador_Colombiano,Liga_de_Gobernantes_Anticorrupción,Movimiento_Autoridades_Indígenas_de_Colombia,Partido_Verde_Oxígeno, Unión_Patriótica, Salvación_Nacional,Partido_Alianza_Social_Independiente,Partido_Cambio_Radical, Partido_Político_Mira}
    public static enum izquierda{Partido_de_la_U,Partido_Alianza_Verde,Partido_Polo_Democrático_Alternativo, Colombia_Humana,Partido_Centro_Democrático,Movimiento_Alternativo_Indígena_y_Social,Partido_Colombia_Justa_Libres,Partido_Colombia_Renaciente,Partido_ADA,Partido_Dignidad_y_Compromiso}
    public static enum Ciudades{Cali, Palmira, Candelaria, Dagua, ElCerrito, Florida, Jamundi, LaCumbre, Pradera, Vijes, Yumbo, tulua, buga}
}
