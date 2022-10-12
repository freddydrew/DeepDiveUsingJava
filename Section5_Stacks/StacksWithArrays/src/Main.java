import java.util.Stack;
public class Main {
    public static void main(String args[]){
        /*LIFO data structure.
         * Push, Pop, and Peep, all refer to top of stack.
         * Ideal with LinkedLists for speed*/

        ArrayStack<Integer> stack1 = new ArrayStack<>();
        ArrayStack<Integer> stack2 = new ArrayStack<>(10);
        ArrayStack<Integer> stack3 = new ArrayStack<>(10,99);
        System.out.println(stack3.peep());
        for (int i = 0; i< 20; i++){
            stack2.push(i);
        }
        System.out.println(stack2.pop());
        System.out.println(stack2.peep());
        stack2.print();
        System.out.println(stack2.search(11));
    }
}
