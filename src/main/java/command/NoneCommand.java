package command;

public class NoneCommand implements Command {
    @Override
    public int execute(int data) {
        return data;
    }
}
