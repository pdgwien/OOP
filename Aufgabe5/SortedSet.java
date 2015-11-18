import java.util.Iterator;

public class SortedSet<Type extends Smaller> extends BasicSet {
    private LinkedList<Type> linkedList;

    SortedSet() {
        this.linkedList = new LinkedList<>();
    }

    public boolean add(Type a) {
        if (!this.linkedList.contains(a) && !this.linkedList.getLast().smaller(a)) {
            this.linkedList.add(a);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Type> iterator() {
        return this.linkedList.iterator();
    }
}
