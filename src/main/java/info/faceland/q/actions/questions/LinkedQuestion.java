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
