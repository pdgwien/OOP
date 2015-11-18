import java.util.Iterator;

public class BasicSet<Type> implements Iterable<Type> {
    private LinkedList<Type> linkedList;

    BasicSet() {
        this.linkedList = new LinkedList<>();
    }

    public boolean add(Type a) {
        if (!this.linkedList.contains(a)) {
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
