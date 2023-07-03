package Interfaz;

import Clases.Arbol;
import Clases.NodosHoja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EtapasPartido extends JFrame {
    private JButton EMPEZARButton;
    private JComboBox comboBox1;
    private JPanel panelPartidos;
    private JLabel txtTitulo;
    private JTextArea textArea1;
    private JButton aceptarButton;

    public EtapasPartido(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPartidos);
        this.pack();
        comboBox1.setEnabled(false);
        aceptarButton.setEnabled(false);
        //panelMostrar.setVisible(false);
        EMPEZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Tamaño del arreglo que me pasan: "+ NodosHoja.getInstancia().getListaNodosHoja().size());
                int controlTama=NodosHoja.getInstancia().getListaNodosHoja().size();

                int contadorFases=0;//nivel en donde estamos
                int fases=0;//Cambio d enivel
                while(controlTama!=1){//controla la altura
                    //cargarComboBoxPARTIDOS();
                    fases=controlTama/2;
                    contadorFases++;
                    txtTitulo.setText("Fase de partido #"+contadorFases);

                    int contadorPartidos=0;
                    while(NodosHoja.getInstancia().getListaNodosHoja().size()>  fases){//controla el emparejamiento
                        contadorPartidos++;
                        Arbol.setResultadoFinal("Fase torneo: "+contadorFases+"\n");
                        AsignarEquipos1 ig=new AsignarEquipos1(contadorPartidos,contadorFases);
                        ig.setVisible(true);

                    }
                    controlTama=NodosHoja.getInstancia().getListaNodosHoja().size();
                    JOptionPane.showMessageDialog(null, "Fin etapa");

                }
                JOptionPane.showMessageDialog(null, "Finalizo fases del torneo");
                //panelMostrar.setVisible(true);
                comboBox1.setEnabled(true);
                aceptarButton.setEnabled(true);
                //dispose();
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedIndex()==0){
                    textArea1.setText(NodosHoja.getInstancia().getListaNodosHoja().get(0).preOrden());
                }
                if(comboBox1.getSelectedIndex()==1){
                    textArea1.setText(Arbol.getResultadoFinal());

                }
                if(comboBox1.getSelectedIndex()==2){
                    textArea1.setText(NodosHoja.getInstancia().getListaNodosHoja().get(0).preOrden());
                }

            }
        });
    }
}
