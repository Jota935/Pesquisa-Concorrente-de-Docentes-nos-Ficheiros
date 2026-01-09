import java.io.BufferedReader;
import java.io.FileReader;

public class Producer extends Thread{
    private String fileName;
    private SharedBuffer buffer;

    public Producer (String fileName, SharedBuffer buffer){
        this.fileName = fileName;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null && !SearchControl.isFound()) {
                lineNumber++;
                NameTask task = new NameTask(line, fileName, lineNumber);
                buffer.put(task);
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler ficheiro: " + fileName);
        }
    }
}