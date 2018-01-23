package design.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entity {

    List<Entity> content;

    public Directory(Directory dir, String name){
        super(dir, name);
        content = new ArrayList<Entity>();
    }

    @Override
    public int size() {
        int count = 0;
        for(Entity E : content){
            count += E.size();
        }
        return count;
    }

    public int getFileCount(){
        int count = 0;
        for(Entity E : content){
            if(E instanceof Directory){
                count += ((Directory) E).getFileCount();
            }else{
                count++;
            }
        }
        return count;
    }

    public boolean removeFile(String name){
        boolean removed = false;

        for(Entity E : content){
            if(E.name == name){
                content.remove(E);
                removed = true;
            }
        }

        if(removed == false){
            for(Entity E : content){
                if(E instanceof Directory){
                    removed = ((Directory) E).removeFile(name);
                    if(removed) break;
                }
            }
        }

        return removed;
    }
}
