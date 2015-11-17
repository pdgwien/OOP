public class MyInteger implements Smaller<MyInteger> {

    private int value;

    public MyInteger() {}

    public MyInteger( int value )
    {
        this.value = value;
    }

    public MyInteger( Integer value )
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    @Override
    public boolean smaller(MyInteger a)
    {
        return this.value < a.getValue();
    }

    @Override
    public String toString()
    {
        return ""+this.value;
    }
}
