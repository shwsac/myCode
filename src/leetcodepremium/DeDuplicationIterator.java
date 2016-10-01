package leetcodepremium;

import java.util.HashSet;
import java.util.Iterator;

public class DeDuplicationIterator implements Iterator<Integer> {

    private Iterator<Integer> itr;
    private HashSet<Integer> hSet;
    private Integer currVal;
    private boolean isHasNext;

    DeDuplicationIterator(Iterator<Integer> itr) {
        this.itr = itr;
        hSet = new HashSet<>();
        currVal = null;
    }

    @Override
    public boolean hasNext() {

        if (isHasNext) {
            return false;
        }
        if (!itr.hasNext()) {
            return false;
        }
        UpdateCurrent();
        isHasNext = true;
        return currVal != null;
    }

    @Override
    public Integer next() {
        if (!isHasNext) {
            UpdateCurrent();
        }
        isHasNext = false;
        if (currVal != null) {
            hSet.add(currVal);
        }
        return currVal;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    private void UpdateCurrent() {
        Integer temp = itr.next();
        while (temp != null && hSet.contains(temp)) {
            temp = itr.next();
        }

        currVal = temp;
    }
}
