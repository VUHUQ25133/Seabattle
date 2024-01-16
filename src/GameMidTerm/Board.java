package GameMidTerm;
import java.util.*;
//Board.java
public class Board {
	private final int rows;
    private final int cols;
    private final Cell[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];

        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }


    public Cell[][] getGrid() {
        return grid;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public boolean isShipSunk(ShipType shipType) {
        // Kiểm tra xem tàu của loại shipType đã bị đánh chìm chưa
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = grid[row][col];
                Ship ship = cell.getShip();
                if (ship != null && ship.getType() == shipType && !ship.isSunk()) {
                    return false; 
                }
            }
        }
        return true;
    }
    public boolean allShipsSunk() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = grid[row][col];
                if (cell.getState() == State.OCCUPIED && !cell.isHit()) {
                    return false;
                }
            }
        }
        return true;
    }
}
