public class SearchControl {
    private static boolean found = false;
    private static NameTask result = null;

    public static synchronized boolean isFound() {
        return found;
    }

    public static synchronized void setFound(NameTask task) {
        if (!found) {
            found = true;
            result = task;
        }
    }

    public static synchronized NameTask getResult() {
        return result;
    }
}