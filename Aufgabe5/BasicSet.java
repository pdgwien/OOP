import java.util.Arrays;
import java.util.Iterator;

public class BasicSet<Type> implements Iterable<Type>
{
    private Iterator<Type> it;
    private Object[] array;

    public BasicSet()
    {
        this.array = new Object[0];
    }

    public void add( Type a )
    {
        this.array = Arrays.copyOf(this.array, this.array.length + 1);
        this.array[this.array.length - 1] = a;
    }

    protected BasicIterator getIterator()
    {
        return new BasicIterator( this.array );
    }

    @Override
    public Iterator iterator()
    {
        this.it = new BasicIterator( this.array );
        return this.it;
    }
}
