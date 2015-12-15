/**
 * @author Patrick Grosslicht <e1227085@student.tuwien.ac.at>
 */
public class MaxCountReachedException extends Exception {
    public MaxCountReachedException() {
        super();
    }

    public MaxCountReachedException(String message) {
        super(message);
    }

    public MaxCountReachedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxCountReachedException(Throwable cause) {
        super(cause);
    }
}
