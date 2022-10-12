import java.util.NoSuchElementException;

public class ArrayQueue2 <T>{

    private T[] queue;
    private int front;
    private int back;

    public ArrayQueue2(){
        this.queue = (T[]) new Object[10];
        this.front = -1;
        this.back = -1;
    }

    public boolean isEmpty(){
        return this.front == -1;
    }

    public boolean isFull(){
        return (this.back + 1) % this.queue.length == this.front;
    }

    public void reSize(){
        T[] tmp = (T[]) new Object[this.queue.length * 2];
        int i = 0;
        int j = this.front;
        do {
            tmp[i] = this.queue[j];
            j = (j + 1) % this.queue.length;
            i++;
        } while (j != this.front);

        this.front = 0;
        this.back = this.queue.length - 1;
        this.queue = tmp;
    }

    public T peek(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.queue[this.front];
    }

    public void enqueue(T item){
        if (this.isFull()){
            this.reSize();
        } else if (this.isEmpty()){
            this.front += 1;
        }
        this.back = (this.back + 1) % this.queue.length;
        this.queue[this.back] = item;
    }

    public T dequeue(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        T item = this.queue[this.front];
        this.queue[this.front] = null;
        if (this.front == this.back){
            this.front = -1;
            this.back = -1;
        }
        this.front = (this.front + 1) % this.queue.length;
        return item;
    }
}
