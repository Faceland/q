package info.faceland.q.actions.questions;

import info.faceland.q.actions.options.InvalidOptionException;
import info.faceland.q.actions.options.Option;

import java.util.List;

public class AbstractQuestion {

    protected int id;
    protected String question;
    protected List<Option> options;
    protected boolean persistence;

    public Option getOption(String command) throws InvalidOptionException {
        for (Option o : options) {
            if (o.isCommand(command)) {
                return o;
            }
        }
        throw new InvalidOptionException();
    }

    public String getQuestion() {
        return question;
    }

    public boolean hasCommand(String command) {
        for (Option o : options) {
            if (o.isCommand(command)) {
                return true;
            }
        }
        return false;
    }

    public List<Option> getOptions() {
        return options;
    }

}
