package command;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandFactory {
    private final List<Integer> output;

    public CommandFactory() {
        output = new ArrayList<>();
    }

    /**
     *
     * @return a int[] copy of the data in this
     */
    public final int[] getOutput() {
        return output.stream().mapToInt(i -> i).toArray();
    }
    static Logger logger = Logger.getLogger(CommandFactory.class.getName());


    public Command getCommand(char code) {
        switch (code) {
            case 'i': return new IncrementCommand();
            case 'd': return new DecrementCommand();
            case 's': return new SquareCommand();
            case 'o': return new OutputCommand(output);
        }
        logger.log(Level.SEVERE, "RuntimeException(\"error\")");
        return new NoneCommand();
    }
}
