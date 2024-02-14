package chess;

import chess.solve.Board;
import chess.solve.Queen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chess")
public class BoardController {

    @GetMapping("/{row}/{column}")
    public ResponseEntity getBoard(@PathVariable int column, @PathVariable int row) {
        if (!Board.onBoard(column, row)) {
            Message message = new Message("ошибка: Указано неверное положение", "Введите значения от 0 до 7");
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
        Queen startQueen = new Queen("Start Queen", column, row);
        Board board = new Board(startQueen);
        board.solve();
        if (board.getBoard() == null) {
            Message message = new Message("ошибка: Нет решения", "Ну, вообще. Такое невозможно");
            return new ResponseEntity(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(board.getQueens(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllSolve() {
        return new ResponseEntity(Board.getAllSolve(), HttpStatus.CREATED);
    }

}
