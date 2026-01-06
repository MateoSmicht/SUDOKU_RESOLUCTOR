package sudoku.controlador;



import sudoku.logica.SudokuSolver;
import sudoku.logica.SudokuGenerador;
import sudoku.logica.SudokuValidador;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	public class SudokuControlador {

	    private SudokuSolver solver;
	    private SudokuGenerador generador;
	    private SudokuValidador validador;
	    private List<int[][]> soluciones;
	    private int indiceSolucionActual;

	    public SudokuControlador() {
	        this.solver = new SudokuSolver();
	        this.generador = new SudokuGenerador();
	        this.validador = new SudokuValidador();
	        this.soluciones = new ArrayList<>();
	        this.indiceSolucionActual = 0;
	    }

	    public int[][] resolverSudoku(int[][] tablero) {
	        soluciones.clear();
	        indiceSolucionActual = 0;
	        
	        // Imprimir el tablero ingresado
	        for (int i = 0; i < 9; i++) {
	            System.out.println(Arrays.toString(tablero[i]));
	        }

	        if (!validarEntrada(tablero)) {
	            JOptionPane.showMessageDialog(null, "El tablero contiene errores. Verificá filas, columnas y subgrillas.");
	            return null;
	        }

	        soluciones = solver.obtenerTodasLasSoluciones(tablero);

	        if (soluciones.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No se encontró solución para este tablero.");
	            return null;
	        }

	        JOptionPane.showMessageDialog(null, "Se encontraron " + soluciones.size() + " soluciones. Mostrando la primera.");
	        return soluciones.get(0);
	    }

	    public int[][] mostrarSoluciones() {
	        if (soluciones.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No hay soluciones cargadas.");
	            return null;
	        }

	        indiceSolucionActual = (indiceSolucionActual + 1) % soluciones.size();
	        return soluciones.get(indiceSolucionActual);
	    }



	    public int[][] generarSudoku(int cantidadPistas) {
	        soluciones.clear();
	        indiceSolucionActual = 0;
	        return generador.generar(cantidadPistas);
	    }

	    public boolean validarEntrada(int[][] tablero) {
	        return validador.esConsistente(tablero);
	    }
	    
	    public void contarSolucionesDelUsuario(int[][] tablero) {
	        if (!validarEntrada(tablero)) {
	            JOptionPane.showMessageDialog(null, "El tablero contiene errores.");
	            return;
	        }

	        if (esTableroDemasiadoVacío(tablero)) {
	            int confirm = JOptionPane.showConfirmDialog(null,
	                "El tablero tiene pocas pistas. El conteo puede tardar mucho.\n¿Querés continuar?",
	                "Advertencia", JOptionPane.YES_NO_OPTION);
	            if (confirm != JOptionPane.YES_OPTION) return;
	        }

	        long inicio = System.nanoTime();
	        int cantidad = solver.contarSoluciones(tablero);
	        long fin = System.nanoTime();
	        double segundos = (fin - inicio) / 1_000_000_000.0;

	        String mensaje = (cantidad >= 1000)
	            ? "Este tablero tiene " + cantidad + " soluciones posibles." 
	            : "Este tablero tiene " + cantidad + " soluciones posibles.";

	        JOptionPane.showMessageDialog(null, mensaje + "\nTiempo de cálculo: " + String.format("%.2f", segundos) + " segundos.");
	    }
	    public static long medirResolucion(SudokuSolver solver, int[][] tablero) {
	        long inicio = System.nanoTime();
	        solver.contarSoluciones(tablero); // o resolver si querés
	        long fin = System.nanoTime();
	        return (fin - inicio) / 1_000_000; // en milisegundos
	    }
	    




	    private boolean esTableroDemasiadoVacío(int[][] tablero) {
	        int vacías = 0;
	        for (int[] fila : tablero) {
	            for (int valor : fila) {
	                if (valor == 0) vacías++;
	            }
	        }
	        return vacías > 60; // ajustar
	    }

	    public int getIndiceSolucionActual() {
	        return indiceSolucionActual;
	    }

	    

	
	}

