public class Main {

    public static int iterativeFactorial(int num){
        if(num == 0){
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= num; i++){
            factorial *= i;
        }
        return factorial;
    }

    public static int recursiveFactorial(int num){
        if (num == 0){
            return 1;
        }
        return num*recursiveFactorial(num-1);
    }

    public static void main(String args[]){
        //after int = 31 the factorial will not fit into an integer sized box of bits, and they return nonsense
        System.out.println("Iterative Factorial 10: " + iterativeFactorial(31));
        System.out.println("Recursive Factorial 10: " + recursiveFactorial(8));
    }
}
