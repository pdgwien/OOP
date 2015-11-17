import java.util.Iterator;
import java.util.NoSuchElementException;

public class BasicIterator<Type> implements Iterator
{
    protected Type[] a;
    protected int curIndex;
    protected int curSize;

    public BasicIterator(Type[] a)
    {
        this.a = a;
        this.curSize = a.length;
    }

    public BasicIterator( BasicIterator<Type> bi )
    {
        this.a = bi.a;
        this.curSize = bi.a.length;
    }

    protected Type getFirstEntry()
    {
        return this.a[0];
    }

    @Override
    public boolean hasNext()
    {
        return this.curIndex < this.curSize && this.a[curIndex] != null;
    }

    @Override
    public Type next()
    {
        return this.a[this.curIndex++];
    }

    @Override
    public void remove()
    {
        if( !this.hasNext() )
        {
            throw new NoSuchElementException();
        }

        if( this.curIndex + 1 < this.curSize )
        {
            System.arraycopy(this.a, this.curIndex + 1, this.a, this.curIndex, this.curSize - this.curIndex - 1);
        }

        this.curSize--;
    }
}
