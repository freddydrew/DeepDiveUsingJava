import java.util.EmptyStackException;

public class SLLStack <T> {

    private node sentinel;
    private int size;

    private class node{
        private T item;
        private node next;

        public node(T item,node next){
            this.item = item;
            this.next = next;
        }
    }

    public SLLStack(){
        this.sentinel = new node(null,null);
        this.size = 0;
    }

    public SLLStack(T item){
        this.sentinel = new node(null,null);
        this.sentinel.next = new node(item, null);
        this.size = 1;
    }

    public void push(T item){
        this.sentinel.next = new node(item,this.sentinel.next);
        this.size += 1;
    }

    public T pop(){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        T item = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.size -= 1;
        return item;
    }

    public T peep(){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        return this.sentinel.next.item;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        return false;
    }

    public boolean search(T item){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        node tmp = this.sentinel.next;
        while (tmp != null){
            if (tmp.item.equals(item)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public void print(){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        node tmp = this.sentinel.next;
        System.out.print("[ ");
        while (tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.print("]" + "\n");
    }
}
