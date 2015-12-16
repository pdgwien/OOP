/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
@Author("Patrick Grosslicht")
public aspect Counter {
    private int count = 0;

    after() returning(Object o) : call(Object+.new(..)) {
        count++;
    }

    after() : execution(* Test.main(..)) {
        System.out.printf("\nObjekte erzeugt: %d", count);
    }
}
