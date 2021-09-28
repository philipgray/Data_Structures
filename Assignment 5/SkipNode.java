public class SkipNode<T extends Comparable> {
    private T data;

    private SkipNode west;
    private SkipNode east;

    private SkipNode north;
    private SkipNode south;


    public SkipNode(T theData) {
        this.data = theData;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;
    }

    public SkipNode(T theData, SkipNode west) {
        this.data = theData;
        this.west = west;
        this.east = null;
        this.north = null;
        this.south = null;
    }

    public SkipNode(T theData, SkipNode west, SkipNode east) {
        this.data = theData;
        this.west = west;
        this.east = east;
        this.north = null;
        this.south = null;
    }

    public SkipNode(T theData, SkipNode west, SkipNode east, SkipNode north) {
        this.data = theData;
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = null;
    }

    public SkipNode(T theData, SkipNode west, SkipNode east, SkipNode north, SkipNode south) {
        this.data = theData;
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
    }

    public T getData() {
        return this.data;
    }

    public SkipNode getWest() {
        return this.west;
    }

    public SkipNode getEast() {
        return this.east;
    }

    public SkipNode getNorth() {
        return this.north;
    }

    public SkipNode getSouth() {
        return this.south;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setWest(SkipNode west) {
        this.west = west;
    }

    public void setEast(SkipNode east) {
        this.east = east;
    }

    public void setNorth(SkipNode north) {
        this.north = north;
    }

    public void setSouth(SkipNode south) {
        this.south = south;
    }
}
