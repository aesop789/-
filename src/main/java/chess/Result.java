package chess;

import chess.solve.Board;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> board = new ArrayList<>();

    Result(Board board) {
        for (int[] line :
                board.getBoard()) {
            String str = "";
            for (int i :
                    line) {
                str += i + " ";
            }
            this.board.add(str);
        }
    }

    public List<String> getBoard() {
        return board;
    }

}
