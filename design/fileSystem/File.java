package design.fileSystem;

public class File extends Entity {

    protected String content;
    int size;

    public File(Directory dir, String name, int size){
        super(dir, name);
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
