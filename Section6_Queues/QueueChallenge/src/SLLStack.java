import java.util.EmptyStackException;

public class SLLStack <T>{
    private int size = 0;
    private node sentinel;

    private class node{
        private T item;
        private node next;

        private node(T item,node next){
            this.item = item;
            this.next = next;
        }
    }

    public SLLStack(){
        this.sentinel = new node(null,null);
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push(T item){
        this.sentinel.next = new node(item,sentinel.next);
        this.size += 1;
    }

    public T pull(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        T item = sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.size -= 1;
        return item;
    }

    public T peek(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.sentinel.next.item;
    }
}
