public class Main {


    public static void main(String args[]){
        ArrayQueue<String> queueEmpty = new ArrayQueue<>();
        ArrayQueue<String> queueCapacityTest = new ArrayQueue<>(100);
        ArrayQueue<String> queue = new ArrayQueue<>(5,"Fred");
        System.out.println("Peek test: " + queue.peek());
        queue.enqueue("Drew");
        queue.enqueue("Dalia");
        queue.enqueue("Yan");
        queue.enqueue("Mom");
        queue.enqueue("Dad");
        queue.enqueue("Dog");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Tom");
        queue.enqueue("Brady");
        queue.enqueue("Dog");
        queue.enqueue("Cat");
        queue.enqueue("Derf");
        queue.enqueue("Big");
        queue.enqueue("Bigger");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
