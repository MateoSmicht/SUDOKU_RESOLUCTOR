package sudoku.logica.test;

import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.logica.SudokuSolver;

public class SudokuSolverTest {

    @Test
    public void testResolverTableroValido() {
        SudokuSolver solver = new SudokuSolver();
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
        assertTrue(solver.resolver(tablero));
    }

    @Test
    public void testContarSolucionesUnica() {
        SudokuSolver solver = new SudokuSolver();
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
        int cantidad = solver.contarSoluciones(tablero);
        assertEquals(1, cantidad);
    }
}
