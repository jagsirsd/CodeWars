package command;

public class SquareCommand implements Command {

    @Override
    public int execute(int data) {
        return data*data;
    }
}