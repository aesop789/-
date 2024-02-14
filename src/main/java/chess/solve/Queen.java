package chess.solve;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Queen {
    private String name;
    private int column;
    private int row;
}
