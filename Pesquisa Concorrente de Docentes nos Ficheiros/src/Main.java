public class Main {
    public static void main(String[] args) throws InterruptedException {

        String targetName = "Guilherme Albuquerque";
        String[] files = {
                "ficha1.txt", "ficha2.txt", "ficha3.txt",
                "ficha4.txt", "ficha5.txt", "ficha6.txt",
                "ficha7.txt", "ficha8.txt", "ficha9.txt"
        };

        SharedBuffer buffer = new SharedBuffer(50);

        Producer[] producers = new Producer[files.length];
        for (int i = 0; i < files.length; i++) {
            producers[i] = new Producer(files[i], buffer);
            producers[i].start();
        }

        Consumer[] consumers = new Consumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer(buffer, targetName);
            consumers[i].start();
        }

        for (Producer p : producers) p.join();
        for (Consumer c : consumers) c.join();

        if (SearchControl.isFound()) {
            NameTask result = SearchControl.getResult();
            System.out.println(
                    "Nome encontrado no ficheiro: " + result.getFileName() + ", na linha: " + result.getLineNumber()
            );
        } else {
            System.out.println("Nome não encontrado em nenhum dos ficheiros.");
        }
    }
}