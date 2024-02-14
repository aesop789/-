package chess.solve;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private List<int[]> allSolve = new ArrayList<>();
    private int[] chessBoard = new int[Board.SIZE];
    private int position = 0;

    public void solve() {
        do {
            if (checking()) {
                if (position == Board.SIZE - 1) {
                    allSolve.add(chessBoard.clone());
                    chessBoard[position]++;
                } else {
                    position++;
                }
            } else {
                chessBoard[position]++;
            }
        } while (chessBoard[0] < Board.SIZE);
    }

    private boolean checking() {
        if (position == 0) {
            return true;
        }
        if (chessBoard[position] > Board.SIZE - 1) {
            chessBoard[position] = 0;
            position--;
            return false;
        }
        for (int i = 0; i < position; i++) {
            if ((chessBoard[position] == chessBoard[i]) |
                    ((Math.abs(chessBoard[position] - chessBoard[i])) == (position - i))) {
                return false;
            }
        }
        return true;
    }

    public List<int[]> getAllSolve() {
        return allSolve;
    }

    public int[] getSolve(int column, int row) {
        if (Board.onBoard(column, row)) {
            for (int[] solve :
                    allSolve) {
                if (solve[row] == column) {
                    return solve;
                }
            }
        }
        return null;
    }
}