import java.util.Iterator;

public class BasicSet<Type> implements Iterable<Type> {
    protected LinkedList<Type> linkedList;

    public BasicSet() {
        linkedList = new LinkedList<>();
    }

    public boolean add(Type a) {
        if (!linkedList.contains(a)) {
            linkedList.add(a);
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }
}
