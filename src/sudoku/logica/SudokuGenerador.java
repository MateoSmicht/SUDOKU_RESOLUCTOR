package sudoku.logica;

import java.util.Random;

public class SudokuGenerador {

    private SudokuSolver solver = new SudokuSolver();
    private Random random = new Random();

    public int[][] generar(int cantidadPistas) {
        int[][] tablero = new int[9][9];
        SudokuSolver solver = new SudokuSolver();
        solver.resolver(tablero); // genera una solución completa

        int[][] tableroConPistas = clonarTablero(tablero);
        Random rand = new Random();
        int pistasActuales = 81;

        while (pistasActuales > cantidadPistas) {
            int fila = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (tableroConPistas[fila][col] != 0) {
                tableroConPistas[fila][col] = 0;
                pistasActuales--;
            }
        }

        return tableroConPistas;
    }

    
  
    private int[][] clonarTablero(int[][] original) {
        int[][] copia = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, 9);
        }
        return copia;
    }
}
