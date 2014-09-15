package info.faceland.q.actions.options;

public class Option {

    protected String command;
    protected String optionDescription;
    protected Runnable reaction;

    public Option(String command, Runnable reaction) {
        this.command = command;
        this.reaction = reaction;
    }

    public Option(String command, Runnable reaction, String optionDescription) {
        this(command, reaction);
        this.optionDescription = optionDescription;
    }

    @Override
    public String toString() {
        return command;
    }

    public boolean hasDescription() {
        return optionDescription != null;
    }

    public String getDescription() {
        if (!hasDescription()) {
            return command;
        }
        return optionDescription;
    }

    public Runnable getReaction() {
        return reaction;
    }

    public String getCommand() {
        return command;
    }

    public boolean isCommand(String s) {
        return command.equalsIgnoreCase(s);
    }

}
