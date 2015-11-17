import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
/*        int[] in = {0, 5, 6, 2, 4, 8, 3, 2, 9, 1, 2};

        SortedSet set = new SortedSet<MyInteger>();

        for (int i : in) {
            set.add(new MyInteger(i));
        }

        Iterator iterator1 = set.iterator();

        while (iterator1.hasNext()) {
            MyInteger value = (MyInteger) iterator1.next();
            if (value != null) {
                if (iterator1.hasNext()) {
                    System.out.print(value.getValue() + ", ");
                } else {
                    System.out.print(value.getValue());
                }
            }
        }*/

        LinkedList<Integer> mytree = new LinkedList<>();
        mytree.add(10);
        mytree.add(8);
        mytree.add(20);
        mytree.add(5);
        mytree.add(11);
        mytree.add(30);
        System.out.println(mytree);
        System.out.println("Size: " + mytree.size());

        Iterator it = mytree.iterator();

        for (Iterator<Integer> iterator = mytree.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next == 30) {
                iterator.remove();
            }
            System.out.println(next);
        }

        System.out.println(mytree);
        System.out.println("Size: " + mytree.size());
    }
}
