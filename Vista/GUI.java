package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import Modelo.Candidatos;
import Controlador.*;

import org.netbeans.lib.awtextra.*;

/**
 *
 * @author Anderson
 */
public class GUI extends javax.swing.JFrame {
    public static List<Candidatos> candidatos = new ArrayList<>
    ();
    private static int index = 0;
    
    public GUI() {
        initComponents();
    }
    private static void mostrarVentanaActual() {
        if (index < candidatos.size()) {
            JFrame frame = new JFrame("Ventana para " + candidatos.get(index));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 150);
            frame.setLayout(new GridLayout(3, 1));
    
            JLabel label = new JLabel("Ingrese el número de votos para el candidato: " + candidatos.get(index));
            label.setHorizontalAlignment(JLabel.CENTER);
    
            JTextField numerodevotos = new JTextField(15);
    
            JButton siguienteButton = new JButton("Siguiente");
            siguienteButton.setBackground(new Color(29, 26, 175));
            siguienteButton.setForeground(Color.white);
            siguienteButton.addActionListener(e -> {
                try {
                    int votos = Integer.parseInt(numerodevotos.getText());

                    (candidatos.get(index)).setNumero_votos(votos);
                    // Puedes hacer algo con el número de votos, como almacenarlo en una lista.
                    index++;
                    
                    frame.dispose(); // Cierra la ventana actual
                    mostrarVentanaActual(); // Muestra la siguiente ventana
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido de votos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            frame.add(label);
            frame.add(numerodevotos);
            frame.add(siguienteButton);
    
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.setVisible(true);
        } else {
            // Mostrar ganador
            Candidatos ganador = CandidatosControlador.determinarGanador(candidatos);
            JOptionPane.showMessageDialog(null, "Fin de la votacion. El candidato ganador es: " + ganador.getNombre() + " con "+ ganador.getNumero_votos() + " votos.");
            JOptionPane.showMessageDialog(null, CandidatosControlador.encontrarPartidoConMasCandidatos(candidatos), "Resultados", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, CandidatosControlador.top3CiudadesConMenosCandidatos(candidatos), "Resultados", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                     
    public void initComponents() {
        /*candidatos.addAll(Candidatos.generarListaCandidatos());

        // Imprimir la lista de candidatos
        for (Candidatos candidato : candidatos) {
            System.out.println(candidato.toString());
        }*/

        Menu = new javax.swing.JPanel();
        Borrar = new javax.swing.JButton();
        Insertar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Listar = new javax.swing.JButton();
        Finalizar = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
        Dinamico = new javax.swing.JPanel();
        Inicio inicio = new Inicio();
        Actualizar actualizar = new Actualizar();
        Listar listar = new Listar();
        Borrar borrar = new Borrar(); 
        
        inicio.setSize(530,700);
        inicio.setLocation(0,0);

        actualizar.setSize(530,700);
        actualizar.setLocation(0,0);

        listar.setSize(530,700);
        listar.setLocation(0,0);

        borrar.setSize(530,700);
        borrar.setLocation(0,0);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(28, 30, 65));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
 
        Borrar.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        
        Borrar.setForeground(new java.awt.Color(232, 232, 232));
        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("borrar-usuario.png"))); // NOI18N
        Borrar.setBackground(new Color(28, 30, 65));
        Borrar.setText("Borrar Candidatos");
        Borrar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Borrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        EstilosButton(Borrar);
        EstilosButton(Insertar);
        EstilosButton(Listar);
        EstilosButton(Actualizar);
        /*EstilosButton(Insertar);*/
        Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BorrarMouseExited(evt);
            }
        });
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        Menu.add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 330, 64));

       Color fondo = new Color(28,30,65);

        Insertar.setBackground(fondo);
        
        Insertar.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        Insertar.setForeground(new java.awt.Color(233, 233, 233));
        Insertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("agregar-usuario.png"))); // NOI18N
        Insertar.setText("Insertar Candidatos");
        Insertar.setBorder(null);
        Insertar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Insertar.setFocusPainted(false);
        Insertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InsertarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InsertarMouseExited(evt);
            }
        });
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ActualizarMouseExited(evt);
            }
        });
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Menu.add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 330, 64));

        Actualizar.setBackground(new java.awt.Color(28, 30, 65));
        Actualizar.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(232, 232, 232));
        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("editar-informacion.png"))); // NOI18N
        Actualizar.setText("Actualizar Candidatos");
        Actualizar.setBorder(null);
        Actualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        Menu.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 330, 64));

        Listar.setBackground(new java.awt.Color(28, 30, 65));
        Listar.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        Listar.setForeground(new java.awt.Color(232, 232, 232));
        Listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("grupo.png"))); // NOI18N
        Listar.setText("Listar Candidatos");
        Listar.setBorder(null);
        Listar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ListarMouseExited(evt);
            }
        });
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });
        Menu.add(Listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 330, 64));

        Finalizar.setBackground(new java.awt.Color(0, 149, 66));
        Finalizar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        Finalizar.setForeground(new java.awt.Color(255, 255, 255));
        Finalizar.setText("Finalizar");
        Finalizar.setBorder(null);
        Finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FinalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FinalizarMouseEntered(evt);
            }
        });
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        Menu.add(Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 135, 44));

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("votacion.png"))); // NOI18N
        Menu.add(icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 700));
        Insertar.setOpaque(false);

        Dinamico.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Dinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 820, 700));
        Dinamico.removeAll();
        Dinamico.add(inicio, BorderLayout.CENTER);
        /*Insertar.setContentAreaFilled(false);*/
        pack();
    }// </editor-fold>                        

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Borrar borrar = new Borrar();
        borrar.setSize(530,700);
        borrar.setLocation(0,0);
        getContentPane().add(Dinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 820, 700));
        Dinamico.removeAll();
        Dinamico.add(borrar, BorderLayout.CENTER);
        Dinamico.revalidate();
        Dinamico.repaint();
    }                                      
/* 
 * Partido_de_la_U,Partido_Alianza_Verde,Partido_Polo_Democrático_Alternativo, Colombia_Humana,Partido_Centro_Democrático,Movimiento_Alternativo_Indígena_y_Social,Partido_Colombia_Justa_Libres,Partido_Colombia_Renaciente,Partido_ADA,Partido_Dignidad_y_Compromiso
 */
                                   

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Insertar insertar = new Insertar();
        insertar.setSize(530,700);
        insertar.setLocation(0,0);
        getContentPane().add(Dinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 820, 700));
        Dinamico.removeAll();
        Dinamico.add(insertar, BorderLayout.CENTER);
        Dinamico.revalidate();
        Dinamico.repaint();
    }                                        

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Actualizar actualizar = new Actualizar();
        actualizar.setSize(530,700);
        actualizar.setLocation(0,0);
        getContentPane().add(Dinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 820, 700));
        Dinamico.removeAll();
        Dinamico.add(actualizar, BorderLayout.CENTER);
        Dinamico.revalidate();
        Dinamico.repaint();
    }                                          

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Listar listar = new Listar();
        listar.setSize(530,700);
        listar.setLocation(0,0);
        getContentPane().add(Dinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 820, 700));
        Dinamico.removeAll();
        Dinamico.add(listar, BorderLayout.CENTER);
        Dinamico.revalidate();
        Dinamico.repaint();
    }                                      

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        mostrarVentanaActual();
    }                                         

    private void FinalizarMouseEntered(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        Finalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }                                      

    private void InsertarMouseEntered(java.awt.event.MouseEvent evt)
     {  
        Insertar.setContentAreaFilled(true);                                      
        Insertar.setBackground(new Color(22,124,217)); 
        Insertar.setContentAreaFilled(true);
        
        Insertar.setFocusPainted(false);
        Insertar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       // TODO add your handling code here:
    }
    private void BorrarMouseEntered(java.awt.event.MouseEvent evt)
     {  
        Borrar.setContentAreaFilled(true);                                      
        Borrar.setBackground(new Color(22,124,217)); 
        Borrar.setBorderPainted(false);
        Borrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       // TODO add your handling code here:
    }
    private void ActualizarMouseEntered(java.awt.event.MouseEvent evt)
     {  
        Actualizar.setContentAreaFilled(true);                                      
        Actualizar.setBackground(new Color(22,124,217)); 
        Actualizar.setBorderPainted(false);
        Actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       // TODO add your handling code here:
    }
    private void ListarMouseEntered(java.awt.event.MouseEvent evt)
     {  
        Listar.setContentAreaFilled(true);                                      
        Listar.setBackground(new Color(22,124,217)); 
        Listar.setBorderPainted(false);
        Listar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       // TODO add your handling code here:
    }

    private void InsertarMouseExited(java.awt.event.MouseEvent evt){
        Insertar.setContentAreaFilled(false);   
    }
    private void ActualizarMouseExited(java.awt.event.MouseEvent evt){
        Actualizar.setContentAreaFilled(false);   
    }
    private void ListarMouseExited(java.awt.event.MouseEvent evt){
        Listar.setContentAreaFilled(false);   
    }
    private void BorrarMouseExited(java.awt.event.MouseEvent evt){
        Borrar.setBackground(new Color(28,30,65));
        Borrar.setContentAreaFilled(false);   
    }
    private void EstilosButton(JButton button){
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }                        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    public static void Insertar(Candidatos candi){
        candidatos.add(candi);
    }
    public static void Actualizar(Candidatos candidatoactualizado){
        for (Candidatos candidato : candidatos){
            if (candidato.getCedula() == candidatoactualizado.getCedula() ) {
                candidato.setNombre(candidatoactualizado.getNombre());
            candidato.setLista_promesas(candidatoactualizado.getLista_promesas());
            candidato.setCiudad_origen(candidatoactualizado.getCiudad_origen());
            candidato.setPartido_politico(candidatoactualizado.getPartido_politico());
            candidato.setOrientacion_politica(candidatoactualizado.getOrientacion_politica());
            candidato.setNumero_votos(candidatoactualizado.getNumero_votos());
            }
        }
    }
    
    

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Finalizar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Listar;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Dinamico;
    private javax.swing.JLabel icono;
    // End of variables declaration                   
}
