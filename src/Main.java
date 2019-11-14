import com.conwaysGameOfLife.IO.ConsoleInput;
import com.conwaysGameOfLife.IO.ConsoleOutput;
import com.conwaysGameOfLife.IO.InputParser;
import com.conwaysGameOfLife.Mechanics;
import com.conwaysGameOfLife.Render.GridStringRender;

public class Main {

    public static void main(String[] args) {
        Mechanics conwaysGameOfLife = new Mechanics(new ConsoleInput(), new ConsoleOutput(), new GridStringRender(), new InputParser());
        conwaysGameOfLife.runGame();
    }
}

