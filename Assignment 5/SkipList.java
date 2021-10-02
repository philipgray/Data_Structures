public class SkipList <T extends Comparable> implements SearchList {

    SkipTower skipListTower;
    int len = 0;

    public SkipList() {
        this.skipListTower = new SkipTower();
    }

    public void insert(T newData) {

        if (skipListTower.getTop() == null) {

            skipListTower.setTop(new SkipNode(newData));
            skipListTower.setBottom(skipListTower.getTop());
            len++;

        } else {

            boolean operationIncomplete = true;
            SkipNode current = skipListTower.getTop();

            while (operationIncomplete) {

                if (newData.compareTo(current.getData()) <= 0) {
                    // if our new data is less than current data

                    if (current.getWest() == null) {
                        // if oue newData is less than current data
                        current.setWest(new SkipNode(newData, null, current));
                        skipListTower.setTop(current.getWest());
                    } else {
                        // if newData is less than or equal to an item in our list
                        SkipNode west = current.getWest();
                        west.setEast(new SkipNode(newData, west, current));
                        current.setWest(west.getEast());

                    }
                    len++;
                    operationIncomplete = false;

                } else if (current.getWest() == null) {
                    current.setWest(new SkipNode(newData, current));
                    len++;
                } else {
                    current = current.getWest();
                }
                // if

            } // while (operationIncomplete)
        } // else
    } // insert

    public boolean search(T newData) {

        boolean operationComplete = false;
        return operationComplete;
    } // search

    public boolean remove(T newData) {

        boolean operationComplete = false;
        return operationComplete;

    } // remove


} // end of class
