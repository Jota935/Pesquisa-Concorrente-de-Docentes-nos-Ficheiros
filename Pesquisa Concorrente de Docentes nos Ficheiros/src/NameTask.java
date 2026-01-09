public class NameTask {
    private String name;
    private String fileName;
    private int lineNumber;

    public NameTask(String name, String fileName, int lineNumber){
        this.name = name;
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    public String getName(){
        return name;
    }

    public String getFileName(){
        return fileName;
    }

    public int getLineNumber(){
        return lineNumber;
    }
}