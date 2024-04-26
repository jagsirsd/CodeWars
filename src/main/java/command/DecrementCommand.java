package command;


public class DecrementCommand implements Command {

    @Override
    public int execute(int data) {
        return data-1;
    }
}
