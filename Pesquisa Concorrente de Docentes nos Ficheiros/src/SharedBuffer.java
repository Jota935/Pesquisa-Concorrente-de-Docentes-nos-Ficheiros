import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private Queue<NameTask> buffer = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void put(NameTask task) throws InterruptedException {
        while (buffer.size() ==  capacity && !SearchControl.isFound()){
            wait();
        }

        if (SearchControl.isFound()) return;

        buffer.add(task);
        notifyAll();
    }

    public synchronized NameTask take() throws InterruptedException{
        while (buffer.isEmpty() && !SearchControl.isFound()){
            wait();
        }

        if (buffer.isEmpty()) return null;

        NameTask task = buffer.poll();
        notifyAll();
        return task;
    }
}
