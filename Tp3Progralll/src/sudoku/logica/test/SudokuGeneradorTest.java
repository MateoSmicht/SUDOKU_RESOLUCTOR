package sudoku.logica.test;

import org.junit.Test;


import static org.junit.Assert.*;

import java.util.List;

import sudoku.controlador.SudokuControlador;
import sudoku.logica.SudokuGenerador;
import sudoku.logica.SudokuSolver;
import sudoku.logica.SudokuValidador;

public class SudokuGeneradorTest {

    @Test
    public void testGenerarCon25Pistas() {
        SudokuGenerador generador = new SudokuGenerador();
        SudokuValidador validador = new SudokuValidador();
        int[][] tablero = generador.generar(25);

        int pistas = 0;
        for (int[] fila : tablero) {
            for (int valor : fila) {
                if (valor != 0) pistas++;
            }
        }

        assertEquals(25, pistas);
        assertTrue(validador.esConsistente(tablero));
    }
    


       
       
      

       
    }
    


