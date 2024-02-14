package chess.solve;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int SIZE = 8;
    int[][] board = new int[SIZE][SIZE];
    Queen[] queens = new Queen[SIZE];
    Queen startQueen;

    public Board(Queen startQueen) {
        this.startQueen = startQueen;
    }

    public void solve() {
        Solver solver = new Solver();
        solver.solve();
        int[] solve = solver.getSolve(startQueen.getColumn(), startQueen.getRow());
        if (solve == null) {
            board = null;
            return;
        }
        for (int i = 0; i < solve.length; i++) {
            Queen queen = new Queen("Queen " + i, solve[i], i);
            queens[i] = queen;
            board[solve[i]][i] = 1;
        }
        queens[startQueen.getRow()].setName("Start Queen");
    }

    public int[][] getBoard() {
        return board;
    }

    public Queen[] getQueens() {
        return queens;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static boolean onBoard(int column, int row) {
        if (!(column > -1 && column < Board.SIZE)) {
            return false;
        }
        if (!(row > -1 && row < Board.SIZE)) {
            return false;
        }
        return true;
    }

    public static List<Queen[]> getAllSolve() {
        Solver solver = new Solver();
        solver.solve();
        List<Queen[]> allSolve = new ArrayList<>();
        for (int[] solve :
                solver.getAllSolve()) {
            Queen[] queens = new Queen[SIZE];
            for (int i = 0; i < solve.length; i++) {
                Queen queen = new Queen("Queen " + i, solve[i], i);
                queens[i] = queen;
            }
            allSolve.add(queens);
        }
        return allSolve;
    }
}
