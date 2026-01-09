public class Consumer extends Thread{
    private SharedBuffer buffer;
    private String targetName;

    public Consumer(SharedBuffer buffer, String targetName){
        this.buffer = buffer;
        this.targetName = targetName;
    }

    @Override
    public void run() {
        try {
            while (!SearchControl.isFound()) {
                NameTask task = buffer.take();
                if (task == null) continue;

                if (task.getName().equalsIgnoreCase(targetName)) {
                    SearchControl.setFound(task);
                    synchronized (buffer) {
                        buffer.notifyAll();
                    }
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
