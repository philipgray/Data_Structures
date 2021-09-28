public class SkipList <T extends Comparable> implements SearchList {

    SkipTower skipListTower;

    public SkipList() {
        this.skipListTower = new SkipTower();
    }

    public void insert(T newData) {

        if (skipListTower.getTop() == null) {

            skipListTower.setTop(new SkipNode(newData));
            skipListTower.setBottom(skipListTower.getTop());

        } else {

            boolean operationIncomplete = true;
            SkipNode current = skipListTower.getTop();

            while (operationIncomplete) {

                if (newData.compareTo(current.getData()) <= 0) {
                    // if our new data

                    if (current.getWest() == null) {
                        current.setWest(new SkipNode(newData, null, current));
                    }

                } // if (newData compared to current)

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
