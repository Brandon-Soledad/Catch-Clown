package mypackage;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Brandizzy on 5/18/2017.
 */
public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);

            temp.tick();
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);

            temp.render(g);
        }
    }
}
