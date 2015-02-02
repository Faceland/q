package info.faceland.q;

import info.faceland.q.actions.questions.QuestionManager;
import org.bukkit.event.HandlerList;
import org.nunnerycode.facecore.logging.PluginLogger;
import org.nunnerycode.facecore.plugin.FacePlugin;

import java.util.Arrays;
import java.util.logging.Level;

public class QPlugin extends FacePlugin {

    private QuestionManager questionManager;
    private QListener qListener;
    private PluginLogger debugPrinter;

    @Override
    public void enable() {
        debugPrinter = new PluginLogger(this);
        questionManager = new QuestionManager();
        qListener = new QListener(this);
        getServer().getPluginManager().registerEvents(qListener, this);
    }

    @Override
    public void disable() {
        questionManager = null;
        HandlerList.unregisterAll(qListener);
        qListener = null;
    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void debug(Level level, String... message) {
        if (debugPrinter != null) {
            this.debugPrinter.log(level, Arrays.asList(message));
        }
    }

}
