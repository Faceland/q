package info.faceland.q;

import com.tealcube.minecraft.bukkit.facecore.logging.PluginLogger;
import com.tealcube.minecraft.bukkit.facecore.plugin.FacePlugin;
import info.faceland.q.actions.questions.QuestionManager;
import org.bukkit.event.HandlerList;

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
