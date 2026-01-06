package sudoku.logica;

public class SudokuValidador {

	public boolean esConsistente(int[][] tablero) {
	    for (int fila = 0; fila < 9; fila++) {
	        for (int col = 0; col < 9; col++) {
	            int num = tablero[fila][col];
	            if (num != 0) {
	                tablero[fila][col] = 0; // lo quitamos temporalmente
	                if (!esValido(tablero, fila, col, num)) {
	                    tablero[fila][col] = num; // lo restauramos
	                    return false;
	                }
	                tablero[fila][col] = num; // lo restauramos
	            }
	        }
	    }
	    return true;
	}


    boolean esValido(int[][] tablero, int fila, int col, int num) {
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
}
