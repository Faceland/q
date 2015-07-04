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
