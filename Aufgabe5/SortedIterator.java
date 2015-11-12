package aufgabe5;

public class SortedIterator<T extends Smaller> extends BasicIterator<T>
{
    private T lastEntry;

    public SortedIterator(T[] a)
    {
        super(a);
    }

    public SortedIterator( BasicIterator<T> bi )
    {
        super(bi);

        this.lastEntry = super.getFirstEntry();
    }

    @Override
    public T next()
    {
        T mi = super.next();
        T ret = null;
        if( this.lastEntry.smaller( mi ) )
        {
            ret = this.lastEntry = mi;
        }

        return ret;
    }
}
