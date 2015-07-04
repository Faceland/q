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
package info.faceland.q.actions.options;

public class Option {

    protected String command;
    protected String optionDescription;
    protected Runnable reaction;

    public Option(String command, Runnable reaction) {
        this.command = command;
        this.reaction = reaction;
    }

    public Option(String command, Runnable reaction, String optionDescription) {
        this(command, reaction);
        this.optionDescription = optionDescription;
    }

    @Override
    public String toString() {
        return command;
    }

    public boolean hasDescription() {
        return optionDescription != null;
    }

    public String getDescription() {
        if (!hasDescription()) {
            return command;
        }
        return optionDescription;
    }

    public Runnable getReaction() {
        return reaction;
    }

    public String getCommand() {
        return command;
    }

    public boolean isCommand(String s) {
        return command.equalsIgnoreCase(s);
    }

}
