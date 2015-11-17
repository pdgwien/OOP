public class SortedSet<Type extends Smaller> extends BasicSet {

    public boolean add(Type a) {
        if (!linkedList.contains(a) && !a.smaller(linkedList.getLast())) {
            linkedList.add(a);
            return true;
        }
        return false;
    }
}
