package sudoku.interfaz;

import javax.swing.*;
import java.awt.*;

public class SudokuPanel extends JPanel {

    private JTextField[][] celdas;

    public SudokuPanel() {
        setLayout(new GridLayout(9, 9));
        celdas = new JTextField[9][9];

        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                JTextField campo = new JTextField();
                campo.setHorizontalAlignment(JTextField.CENTER);
                campo.setFont(new Font("Arial", Font.BOLD, 18));
                campo.setDocument(new JTextFieldLimit(1));

                // Bordes para subgrillas 3x3
                int top = (fila % 3 == 0) ? 10 : 1;
                int left = (col % 3 == 0) ? 10 : 1;
                int bottom = (fila == 8) ? 10 : 1;
                int right = (col == 8) ? 10 : 1;

                campo.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

                celdas[fila][col] = campo;
                add(campo);
            }
        }


    }

    public int[][] getTablero() {
        int[][] tablero = new int[9][9];
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                String texto = celdas[fila][col].getText();
                tablero[fila][col] = texto.isEmpty() ? 0 : Integer.parseInt(texto);
            }
        }
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                celdas[fila][col].setText(tablero[fila][col] == 0 ? "" : String.valueOf(tablero[fila][col]));
            }
        }
    }

    // Clase auxiliar para limitar caracteres
    private static class JTextFieldLimit extends javax.swing.text.PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            this.limit = limit;
        }

        public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
            if (str == null) return;
            if ((getLength() + str.length()) <= limit && str.matches("[1-9]?")) {
                super.insertString(offset, str, attr);
            }
        }
    }
    
    

}
