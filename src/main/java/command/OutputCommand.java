package command;

import java.util.List;

public class OutputCommand implements Command {

    private final List<Integer> output;

    public OutputCommand(List<Integer> output) {
        this.output = output;
    }

    @Override
    public int execute(int data) {
        output.add(data);
        return data;
    }
}
