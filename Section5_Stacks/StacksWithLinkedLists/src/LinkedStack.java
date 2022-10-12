import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack <T>{

    private LinkedList<T> stack;

    public LinkedStack(){
        stack = new LinkedList<>();
    }

    public LinkedStack(T item){
        stack = new LinkedList<>();
        stack.push(item);
    }

    public void push(T item){
        stack.push(item);
    }

    public T pop(){
        return stack.pop();
    }

    public T peep(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void print(){
        ListIterator<T> iterator = stack.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
