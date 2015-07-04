/**
 * The MIT License
 * Copyright (c) 2015 Teal Cube Games
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
    private static QPlugin instance;

    public static QPlugin getInstance() {
        return instance;
    }

    @Override
    public void enable() {
        instance = this;
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
