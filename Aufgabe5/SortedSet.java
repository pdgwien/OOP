package aufgabe5;

import java.util.Iterator;

public class SortedSet<Type extends Smaller> extends BasicSet
{
    @Override
    public Iterator iterator()
    {
        return new SortedIterator( super.getIterator() );
    }
}
