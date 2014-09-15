package info.faceland.q.actions.questions;

import info.faceland.q.actions.options.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LinkedQuestion extends AbstractQuestion {

    private List<UUID> targets;

    public LinkedQuestion(int id, List<UUID> targets, String message, List<Option> options) {
        this.id = id;
        this.targets = targets;
        this.question = message;
        this.options = new ArrayList<>(options);
        for (Option o : options) {
            if (o.getReaction() instanceof QuestionTask) {
                ((QuestionTask) o.getReaction()).setQuestion(this);
            }
        }
    }

    public LinkedQuestion(int id, List<UUID> targets, String message, List<Option> options, boolean persistence) {
        this(id, targets, message, options);
        this.persistence = persistence;
    }

    public LinkedQuestion newInstance(List<UUID> targets) {
        return new LinkedQuestion(QuestionManager.getNextQuestionId(), targets, this.question, this.options,
                                  this.persistence);
    }

    public List<UUID> getTargets() {
        return targets;
    }

}
