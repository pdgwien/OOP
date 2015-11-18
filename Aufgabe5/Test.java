import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        BasicSet<Integer> bsi = new BasicSet<>();
        SortedSet<MyInteger> ssmi = new SortedSet<>();
        SortedSet<Baurundholz> ssbr = new SortedSet<>();
        SortedSet<Baukantholz> ssbk = new SortedSet<>();
        
        bsi.add(5);
        bsi.add(9);
        bsi.add(4);
        bsi.add(1);

        ssmi.add(new MyInteger(5));
        ssmi.add(new MyInteger(9));
        ssmi.add(new MyInteger(14));
        ssmi.add(new MyInteger(4));

        Baurundholz br = new Baurundholz(75, 30);
        ssbr.add(new Baurundholz(10, 20));
        ssbr.add(new Baurundholz(100, 5));
        ssbr.add(br);
        ssbr.add(new Baurundholz(25, 75));
        ssbr.add(new Baurundholz(1, 1));

        Baukantholz bk = new Baukantholz(30, 30, 30);
        ssbk.add(new Baukantholz(10, 20, 20));
        ssbk.add(new Baukantholz(10, 20, 30));
        ssbk.add(bk);
        ssbk.add(new Baukantholz(50, 30, 40));
        ssbk.add(new Baukantholz(10, 10, 10));

        System.out.println("BasicSet<Integer>");
        System.out.println("Removing 4");
        for (Iterator<Integer> iterator = bsi.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next == 4) {
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println("Adding 12, 27");
        bsi.add(12);
        bsi.add(27);
        for (Iterator<Integer> iterator = bsi.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println("SortedSet<MyInteger>");
        System.out.println("Removing 9");
        for (Iterator<MyInteger> iterator = ssmi.iterator(); iterator.hasNext(); ) {
            MyInteger next = iterator.next();
            if (next.getValue() == 9) {
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println("Adding 12, 27");
        ssmi.add(new MyInteger(12));
        ssmi.add(new MyInteger(27));
        for (Iterator<MyInteger> iterator = ssmi.iterator(); iterator.hasNext(); ) {
            MyInteger next = iterator.next();
            System.out.println(next);
        }

        System.out.println("SortedSet<Baurundholz>");
        System.out.println("Removing third element");
        for (Iterator<Baurundholz> iterator = ssbr.iterator(); iterator.hasNext(); ) {
            Baurundholz next = iterator.next();
            if (next == br) {
                iterator.remove();
            }
            System.out.println(next.output());
        }
        System.out.println("Adding bigger wood");
        Baurundholz br2 = new Baurundholz(100, 100);
        ssbr.add(br2);
        for (Iterator<Baurundholz> iterator = ssbr.iterator(); iterator.hasNext(); ) {
            Baurundholz next = iterator.next();
            System.out.println(next.output());
        }
        System.out.println("SortedSet<Baukantholz>");
        System.out.println("Removing third element");
        for (Iterator<Baukantholz> iterator = ssbk.iterator(); iterator.hasNext(); ) {
            Baukantholz next = iterator.next();
            if (next == bk) {
                iterator.remove();
            }
            System.out.println(next.output());
        }
        System.out.println("Adding bigger wood");
        Baukantholz bk2 = new Baukantholz(500, 100, 100);
        ssbk.add(bk2);
        for (Iterator<Baukantholz> iterator = ssbk.iterator(); iterator.hasNext(); ) {
            Baukantholz next = iterator.next();
            System.out.println(next.output());
        }


        System.out.println("SortedSet<Bauholz>");
        SortedSet<Bauholz> ssb = new SortedSet<>();
        for (Iterator<Baurundholz> iterator = ssbr.iterator(); iterator.hasNext(); ) {
            Baurundholz next = iterator.next();
            ssb.add(next);
        }
        for (Iterator<Baukantholz> iterator = ssbk.iterator(); iterator.hasNext(); ) {
            Baukantholz next = iterator.next();
            ssb.add(next);
        }
        for (Iterator<Bauholz> iterator = ssb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            System.out.println(next);
        }
        System.out.println("Removing last element");
        for (Iterator<Bauholz> iterator = ssb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            if (next == bk2) {
                iterator.remove();
            }
        }
        for (Iterator<Bauholz> iterator = ssb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            System.out.println(next);
        }
        System.out.println("BasicSet<Bauholz>");
        BasicSet<Bauholz> bsb = ssb;
        for (Iterator<Bauholz> iterator = bsb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            System.out.println(next);
        }
        System.out.println("Removing last element & adding small one");
        for (Iterator<Bauholz> iterator = bsb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            if (next == br2) {
                iterator.remove();
            }
        }
        bsb.add(new Baurundholz(1, 1));
        for (Iterator<Bauholz> iterator = bsb.iterator(); iterator.hasNext(); ) {
            Bauholz next = iterator.next();
            System.out.println(next);
        }
    }
}
