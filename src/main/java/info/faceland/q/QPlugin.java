package info.faceland.q;

import info.faceland.api.FacePlugin;
import info.faceland.q.actions.questions.QuestionManager;
import net.nunnerycode.java.libraries.cannonball.DebugPrinter;
import org.bukkit.event.HandlerList;

import java.util.logging.Level;

public class QPlugin extends FacePlugin {

    private QuestionManager questionManager;
    private QListener qListener;
    private DebugPrinter debugPrinter;

    @Override
    public void preEnable() {

    }

    @Override
    public void enable() {
        debugPrinter = new DebugPrinter(getDataFolder().getName(), "debug.log");
        questionManager = new QuestionManager();
        qListener = new QListener(this);
        getServer().getPluginManager().registerEvents(qListener, this);
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

    public void debug(Level level, String... message) {
        if (debugPrinter != null) {
            this.debugPrinter.debug(level, message);
        }
    }

}
