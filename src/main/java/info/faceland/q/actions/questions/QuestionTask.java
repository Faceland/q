package info.faceland.q.actions.questions;

import info.faceland.q.actions.options.OptionTask;

public abstract class QuestionTask extends OptionTask {

    protected AbstractQuestion question;

    public AbstractQuestion getQuestion() {
        return question;
    }

    public void setQuestion(AbstractQuestion question) {
        this.question = question;
    }

}
