package info.faceland.q.actions.questions;

import info.faceland.q.actions.options.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question extends AbstractQuestion {

    protected UUID target;

    public Question(UUID target, String question, List<Option> optionList) {
        this.id = QuestionManager.getNextQuestionId();
        this.target = target;
        this.question = question;
        this.options = new ArrayList<>(optionList);
        for (Option o : optionList) {
            if (o.getReaction() instanceof QuestionTask) {
                ((QuestionTask) o.getReaction()).setQuestion(this);
            }
        }
    }

    public Question(UUID target, String question, List<Option> optionList, boolean persistence) {
        this(target, question, optionList);
        this.persistence = persistence;
    }

    public Question newInstance(UUID target) {
        return new Question(target, question, options, persistence);
    }

    public UUID getTarget() {
        return target;
    }

}
