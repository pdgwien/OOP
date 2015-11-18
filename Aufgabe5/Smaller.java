public interface Smaller<T extends Smaller<T>> {
    boolean smaller(T a);
}
