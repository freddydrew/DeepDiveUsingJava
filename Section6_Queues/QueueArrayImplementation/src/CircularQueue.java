import java.util.NoSuchElementException;

public class CircularQueue <T>{

    private int front;
    private int back;
    private T[] queue;

    public CircularQueue(){
        this.front = -1;
        this.back = -1;
        this.queue = (T[]) new Object[10];
    }

    public void enqueue(T item){
        //check if the queue is full, if true then resize
        if (this.isFull()){
            this.reSize();
        }
        //check if its empty, if so increment front
        if (this.isEmpty()){
            this.front += 1;
        }
        //increment the back using a modulo to loop around
        this.back = (this.back + 1) % this.queue.length;
        //insert the item
        this.queue[this.back] = item;
    }

    public T dequeue(){
        //check if the queue is empty, if so throw exemption
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        //strore the item at front
        T item = this.queue[this.front];
        //check if front = back because that would indicate a queue of size 1,if so reset to -1 so its empty again
        if (this.front == this.back){
            this.front = this.back = -1;
        } else { //else set front using modulo math
            this.front = (this.front + 1) % this.queue.length;
        }
        //return the front item you saved
        return item;
    }

    public T peek(){
        //if empty, throw exception
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        //if not return thing at front
        return this.queue[this.front];
    }

    public boolean isEmpty(){
        //check if front is -1, because that's the only time it will be that
        return this.front == -1;
    }

    public boolean isFull(){
        //check if the incremented back would be equal to front
        return (this.back + 1) % this.queue.length == this.front;
    }

    public void reSize(){
        //create temp array
        T[] tmp = (T[]) new Object[this.queue.length * 2];
        //index for temp array and old array
        int i = 0;
        int j = this.front;

        //avoiding do-while loop because it's easier for me
        tmp[i] = this.queue[j];
        j = (j + 1) % this.queue.length;
        i += 1;

        while(j != this.front){
            tmp[i] = this.queue[j];
            j = (j + 1) % this.queue.length;
            i += 1;
        }
        this.front = 0;
        this.back = this.queue.length - 1;
        this.queue = tmp;
    }

}
