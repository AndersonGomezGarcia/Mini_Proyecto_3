package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Candidatos extends Ciudadano {
    private boolean orientacion_politica;// Si es positivo es de derecha si es negativo es de izquierda
    private String partido_politico;
    private String lista_promesas;
    private int numero_votos;

    public int getNumero_votos() {
        return numero_votos;
    }

    public void setNumero_votos(int numero_votos) {
        this.numero_votos = numero_votos;
    }

    public Candidatos(String nombre, String cedula, String ciudad_origen, boolean orientacionpolitica, String partido_politico, String lista_promesas, int numero_votos) {
        super(nombre, cedula, ciudad_origen);
        this.orientacion_politica = orientacionpolitica;
        this.lista_promesas = lista_promesas;
        this.partido_politico = partido_politico;
        this.numero_votos = numero_votos;

    }
    

    public boolean getOrientacion_politica() {
        return orientacion_politica;
    }

    public void setOrientacion_politica(boolean orientacion_politica) {
        this.orientacion_politica = orientacion_politica;
    }

    public class Ciudadano {

        String nombre;
        String cedula;
        String ciudad_origen;

        public Ciudadano() {
        }

        public Ciudadano(String nombre, String cedula, String ciudad_origen) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.ciudad_origen = ciudad_origen;

        }

        @Override
        public String toString() {
            return "Ciudadano [nombre=" + nombre + ", cedula=" + cedula + ", ciudad_origen=" + ciudad_origen + "]";
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getCiudad_origen() {
            return ciudad_origen;
        }

        public void setCiudad_origen(String ciudad_origen) {
            this.ciudad_origen = ciudad_origen;
        }

    }

    public String getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(String partido_politico) {
        this.partido_politico = partido_politico;
    }

    public String getLista_promesas() {
        return lista_promesas;
    }

    public void setLista_promesas(String lista_promesas) {
        this.lista_promesas = lista_promesas;
    }  
}
