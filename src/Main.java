import com.conwaysgameoflife.io.ConsoleInput;
import com.conwaysgameoflife.io.ConsoleOutput;
import com.conwaysgameoflife.io.InputParser;
import com.conwaysgameoflife.GameOrchestrator;
import com.conwaysgameoflife.render.GridStringRender;

public class Main {

    public static void main(String[] args) {
        GameOrchestrator conwaysGameOfLife = new GameOrchestrator(new ConsoleInput(), new ConsoleOutput(), new GridStringRender(), new InputParser());
        conwaysGameOfLife.runGame();
    }
}

