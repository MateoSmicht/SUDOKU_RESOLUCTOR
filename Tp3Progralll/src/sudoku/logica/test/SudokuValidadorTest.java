package sudoku.logica.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

import sudoku.logica.SudokuValidador;

public class SudokuValidadorTest {

    @Test
    public void testTableroValido() {
        SudokuValidador validador = new SudokuValidador();
        int[][] tablero = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        assertTrue(validador.esConsistente(tablero));
    }

    @Test
    public void testTableroInvalidoPorFila() {
        SudokuValidador validador = new SudokuValidador();
        int[][] tablero = {
            {5,3,3,0,7,0,0,0,0}, // repetido el 3
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        assertFalse(validador.esConsistente(tablero));
    }
    
    @Test
    public void testTableroManualDesdePDF() {
        int[][] tablero = {
            {0, 0, 3, 0, 2, 0, 6, 0, 0},
            {9, 0, 0, 3, 0, 5, 0, 0, 1},
            {0, 0, 1, 8, 0, 6, 4, 0, 0},
            {0, 0, 8, 1, 0, 2, 9, 0, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 6, 7, 0, 8, 2, 0, 0},
            {0, 0, 2, 6, 0, 9, 5, 0, 0},
            {8, 0, 0, 2, 0, 3, 0, 0, 9},
            {0, 0, 5, 0, 1, 0, 3, 0, 0}
        };

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(tablero[i]));
        }

        SudokuValidador validador = new SudokuValidador();
        boolean valido = validador.esConsistente(tablero);

        System.out.println("¿Tablero válido?: " + valido);
        assertTrue("El tablero debería ser válido", valido);
    }
}
