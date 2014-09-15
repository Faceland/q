package info.faceland.q.actions.options;

public abstract class OptionTask implements Runnable {

    protected Option option;

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

}
