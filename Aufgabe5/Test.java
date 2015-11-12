package aufgabe5;

import java.util.Iterator;

public class Test
{
    public static void main(String[] args)
    {
        int[] in = { 0, 5, 6, 2, 4, 8, 3, 2, 9, 1, 2 };

        SortedSet set = new SortedSet<MyInteger>();

        for( int i : in )
        {
            set.add( new MyInteger( i ) );
        }

        Iterator iterator = set.iterator();

        while( iterator.hasNext() )
        {
            MyInteger value = (MyInteger) iterator.next();
            if( value != null )
            {
                if( iterator.hasNext() )
                {
                    System.out.print( value.getValue() + ", " );
                }
                else
                {
                    System.out.print( value.getValue() );
                }
            }
        }
    }
}
