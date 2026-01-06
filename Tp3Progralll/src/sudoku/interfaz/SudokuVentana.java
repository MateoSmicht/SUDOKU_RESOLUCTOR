package sudoku.interfaz;

import sudoku.controlador.SudokuControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuVentana extends JFrame {
    private SudokuPanel panelGrilla;
    private SudokuControlador controlador;
    private JButton btnResolver, btnGenerar, btnSiguiente;
    private JTextField txtCantidadPistas;
    private JButton btnContarSoluciones;
    private JLabel lblIndiceSolucion;



    public SudokuVentana() {
        setTitle("Resolutor de Sudoku");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false); 

        controlador = new SudokuControlador();
        panelGrilla = new SudokuPanel();
        add(panelGrilla, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        

        txtCantidadPistas = new JTextField("25", 3);
        panelBotones.add(new JLabel("Pistas:"));
        panelBotones.add(txtCantidadPistas);

        btnGenerar = new JButton("Generar Aleatorio");
        btnResolver = new JButton("Resolver");
        btnSiguiente = new JButton("Siguiente Solución");
        btnContarSoluciones = new JButton("Contar Soluciones");
        lblIndiceSolucion = new JLabel("Solución: -");
        lblIndiceSolucion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIndiceSolucion.setPreferredSize(new Dimension(150, 25));
        
        panelBotones.add(btnContarSoluciones);
        panelBotones.add(btnGenerar);
        panelBotones.add(btnResolver);
        panelBotones.add(btnSiguiente);
        panelBotones.add(lblIndiceSolucion);
        btnContarSoluciones.setVisible(false);
        btnResolver.setVisible(false);

        add(panelBotones, BorderLayout.SOUTH);

        // Acciones
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pistas = Integer.parseInt(txtCantidadPistas.getText());
                int[][] tablero = controlador.generarSudoku(pistas);
                panelGrilla.setTablero(tablero);
                btnContarSoluciones.setVisible(true);
                btnResolver.setVisible(true);
            }
        });

        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[][] tablero = panelGrilla.getTablero();
                int[][] solucion = controlador.resolverSudoku(tablero);
                if (solucion != null) {
                    panelGrilla.setTablero(solucion);
                }
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[][] siguiente = controlador.mostrarSoluciones();
                if (siguiente != null) {
                    panelGrilla.setTablero(siguiente);
                    int indice = controlador.getIndiceSolucionActual();
                    lblIndiceSolucion.setText("Solución: " + (indice + 1));
                }
            }
        });

        
        btnContarSoluciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[][] tablero = panelGrilla.getTablero();
                controlador.contarSolucionesDelUsuario(tablero);
            }
        });
        
        

    }
    
//MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SudokuVentana ventana = new SudokuVentana(); 
            ventana.setVisible(true);                   
        });
    }

}
