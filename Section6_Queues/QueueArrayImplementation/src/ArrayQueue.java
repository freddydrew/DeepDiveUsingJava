public class ArrayQueue <T>{

    private T[] queue;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(){
        this.queue = (T[]) new Object[10];
        this.front = 0;
        this.back = 0;
        this.size = 0;
        }

    public ArrayQueue(int capacity){
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    public ArrayQueue(int capacity, T item){
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.back = 0;
        this.size = 1;
        this.queue[front] = item;
    }

    public void resize(int capacity){
        T[] tmp = (T[]) new Object[capacity];
        if (this.size == 0){
            this.queue = tmp;
            return;
        }
        int i = 0; //index for new array
        int j = this.front;
        tmp[i] = this.queue[j];
        j = (j + 1) % this.queue.length;
        i++;

        while (j != this.front){
            tmp[i] = this.queue[j];
            j = (j + 1) % this.queue.length;
            i++;
        }

        this.front = 0;
        this.back = this.queue.length - 1;
        this.queue = tmp;
    }

    public void enqueue(T item){
        //queue full, need to expand
        if (this.size == this.queue.length){
            this.resize(this.queue.length*2);
        }

        if (this.size == 0) {
            this.front += 1;
        }

        this.back = (this.back + 1) % this.queue.length;
        this.queue[this.back] = item;
        this.size += 1;
    }

    public T dequeue(){
        if (this.size == 0){
            throw new Error("Queue is empty!");
        }
        T item = this.queue[this.front];
        this.queue[this.front] = null;
        this.front += 1;
        this.size -= 1;
        if (this.size == 0){
            this.front = 0;
            this.back = 0;
            this.resize(10);
        }
        return item;
    }

    public T peek(){
        if (this.size == 0){
            throw new Error("Queue is empty!");
        }
        return this.queue[this.front];
    }


}
