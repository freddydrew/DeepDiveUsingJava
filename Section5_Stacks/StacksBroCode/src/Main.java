import java.util.Stack;
public class Main {
    public static void main(String args[]){
        /*LIFO data structure.
        * Push, Pop, and Peep, all refer to top of stack.
        * Ideal with LinkedLists for speed*/

        Stack<String> stack = new Stack<String>();
        System.out.println(stack.empty());
        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println("Peeping: " + stack.peek());
        while(!stack.empty()){
            stack.pop();
            System.out.println(stack);
        }

        for (int i = 0; i < 1000; i++){
            stack.push("Fallout76");
        }

    }
}
