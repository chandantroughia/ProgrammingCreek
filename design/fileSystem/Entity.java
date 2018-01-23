package design.fileSystem;

public abstract class Entity {
    protected Directory p;
    protected String name;
    protected long lastUpdated;

    protected long created;

    public abstract int size();

    public Entity(Directory dir, String name){
        this.p = dir;
        this.name = name;
        this.created = System.currentTimeMillis();
        this.lastUpdated = System.currentTimeMillis();
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
