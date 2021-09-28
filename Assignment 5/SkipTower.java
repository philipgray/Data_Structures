public class SkipTower <T extends Comparable> {
    protected SkipNode top;
    protected SkipNode bottom;
    protected int height;

    public SkipLinked() {
        this.top = null;
        this.bottom = null;
        this.height = 0;
    }

    public SkipNode getTop() {
        return this.top;
    }

    public SkipNode getBottom() {
        return this.bottom;
    }

    public void setTop(SkipNode top) {
        this.top = top;
    }

    public void setBottom(SkipNode bottom) {
        this.bottom = bottom;
    }

} // class
