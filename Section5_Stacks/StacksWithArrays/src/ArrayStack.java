import java.util.EmptyStackException;

public class ArrayStack <T>{

    private T[] items;
    private int size;

    public ArrayStack(){
        this.items = (T[]) new Object[10];
        this.size = 0;
    }

    public ArrayStack(int capacity){
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayStack(int capacity,T item){
        this.items = (T[]) new Object[capacity];
        this.size = 0;
        this.items[this.size] = item;
        this.size +=1;
    }

    public void push(T item){
        if (this.size == items.length){
            this.resize(items.length*2);
        }
        this.items[this.size]  = item;
        this.size += 1;
    }

    public T pop(){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        T item = this.items[this.size-1];
        this.items[this.size-1] = null;
        this.size -= 1;
        return item;
    }

    public T peep(){
        if (this.size == 0){
            throw new EmptyStackException();
        }
        return this.items[this.size-1];
    }

    public void resize(int capacity){
        T[] newStack = (T[]) new Object[capacity];
        System.arraycopy(this.items,0,newStack,0,this.items.length);
        this.items = newStack;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        return false;
    }

    public void print(){
        System.out.print("[ ");
        for (int i = 0; i < this.size; i++){
            System.out.print(this.items[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public boolean search(T item){
        for (int i = 0; i < this.size; i++){
            if (this.items[i].equals(item)){
                return true;
            };
        }
        return false;
    }
}
