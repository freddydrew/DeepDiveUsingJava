import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String args[]){
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Drew");
        queue.offer("Freddy"); //offer is the same things as pushing
        queue.offer("and");
        queue.offer("Dalia");


        queue.poll(); //poll is the same thing as pulling
        String apellido = queue.peek();
        System.out.println("Next in line: " + apellido);

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }


    }
}
