package command;

public class IncrementCommand implements Command {
    @Override
    public int execute(int data) {
        return data+1;
    }
}
