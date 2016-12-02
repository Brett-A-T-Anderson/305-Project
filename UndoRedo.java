import java.util.ArrayList;
import java.util.List;

/**
 * Created by stapl on 12/2/2016.
 */
public class UndoRedo {
    private List<Query> Undo;
    private List<Query> Redo;

    public UndoRedo(){
        Undo = new ArrayList<Query>();
        Redo = new ArrayList<Query>();
    }

    public void addUndo(Query in){
        Undo.add(in);
    }

    public void addRead(Query in){
        Redo.add(in);
    }

    public Query grabUndo(){
        if (Undo.size() == 0){
            throw new IllegalStateException();
        }
        Query temp = Undo.get(0);
        Undo.remove(0);
        Redo.add(temp);
        return temp;
    }
    public Query grabRedo(){
        if (Redo.size() == 0){
            throw new IllegalStateException();
        }
        Query temp = Redo.get(0);
        Redo.remove(0);
        return temp;
    }

}
