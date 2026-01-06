package sudoku.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuSolver {

	private boolean resolver(int[][] tablero, int fila, int col) {
		if (fila == 9)
			return true; // solución encontrada

		if (col == 9)
			return resolver(tablero, fila + 1, 0);

		if (tablero[fila][col] != 0)
			return resolver(tablero, fila, col + 1);

		for (int num = 1; num <= 9; num++) {
			if (esValido(tablero, fila, col, num)) {
				tablero[fila][col] = num;
				if (resolver(tablero, fila, col + 1))
					return true;
				tablero[fila][col] = 0; // backtrack
			}
		}

		return false; // no hay solución en este camino
	}

	public boolean esValido(int[][] tablero, int fila, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (tablero[fila][i] == num || tablero[i][col] == num) {
				return false;
			}
		}

		int startRow = (fila / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (tablero[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public int contarSoluciones(int[][] tablero) {
		return contar(tablero, 0, 0);
	}

	private int contar(int[][] tablero, int fila, int col) {
		if (fila == 9)
			return 1;
		if (col == 9)
			return contar(tablero, fila + 1, 0);
		if (tablero[fila][col] != 0)
			return contar(tablero, fila, col + 1);

		int total = 0;
		for (int num = 1; num <= 9; num++) {
			if (esValido(tablero, fila, col, num)) {
				tablero[fila][col] = num;
				total += contar(tablero, fila, col + 1);
				tablero[fila][col] = 0;
			}
		}
		return total;
	}

	public boolean resolver(int[][] tablero) {
		return resolver(tablero, 0, 0);
	}

	public int[][] obtenerPrimeraSolucion(int[][] tablero) {
		int[][] copia = clonarTablero(tablero);
		if (resolver(copia))
			return copia;
		return null;
	}

	public List<int[][]> obtenerTodasLasSoluciones(int[][] tablero) {
		List<int[][]> soluciones = new ArrayList<>();
		buscarSoluciones(tablero, soluciones, 50000); // máximo 50000 soluciones
		return soluciones;
	}
	
	private List<Integer> numerosAleatorios() {
	    List<Integer> numeros = new ArrayList<>();
	    for (int i = 1; i <= 9; i++) {
	        numeros.add(i);
	    }
	    Collections.shuffle(numeros);
	    return numeros;
	}


	private void buscarSoluciones(int[][] tablero, List<int[][]> soluciones, int maxSoluciones) {
		if (soluciones.size() >= maxSoluciones)
			return;

		for (int fila = 0; fila < 9; fila++) {
			for (int col = 0; col < 9; col++) {
				if (tablero[fila][col] == 0) {
					for (int num : numerosAleatorios()) {
						if (esValido(tablero, fila, col, num)) {
							tablero[fila][col] = num;
							buscarSoluciones(tablero, soluciones, maxSoluciones);
							tablero[fila][col] = 0;
						}
					}
					return;
				}
			}
		}
		soluciones.add(clonarTablero(tablero));
	}

	private int[][] clonarTablero(int[][] original) {
		int[][] copia = new int[9][9];
		for (int i = 0; i < 9; i++) {
			copia[i] = original[i].clone(); // clona cada fila
		}
		return copia;
	}

	

}
