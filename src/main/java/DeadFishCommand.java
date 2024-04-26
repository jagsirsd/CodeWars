import command.Command;
import command.CommandFactory;

public class DeadFishCommand {
    /**
     * i - increment
     * d - decrement
     * s - square
     * o - output
     *
     * @param data
     * @return
     */
    public static int[] parse(String data) {
        int counter = 0;
        CommandFactory commandFactory = new CommandFactory();
        for (char code: data.toCharArray()) {
            Command command = commandFactory.getCommand(code);
            counter = command.execute(counter);
        }
        return commandFactory.getOutput();
    }
}





