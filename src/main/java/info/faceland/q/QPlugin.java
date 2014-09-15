package info.faceland.q;

import info.faceland.api.FacePlugin;
import info.faceland.q.actions.questions.QuestionManager;
import org.bukkit.event.HandlerList;

public class QPlugin extends FacePlugin {

    private QuestionManager questionManager;
    private QListener qListener;

    @Override
    public void preEnable() {

    }

    @Override
    public void enable() {
        questionManager = new QuestionManager();
        qListener = new QListener(this);
    }

    @Override
    public void postEnable() {

    }

    @Override
    public void preDisable() {

    }

    @Override
    public void disable() {
        questionManager = null;
        HandlerList.unregisterAll(qListener);
        qListener = null;
    }

    @Override
    public void postDisable() {

    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

}
