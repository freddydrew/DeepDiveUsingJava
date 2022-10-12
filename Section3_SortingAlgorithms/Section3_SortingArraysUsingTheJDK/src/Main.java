import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int[] arr = new int[]{20,35,-15,7,55,1,-22};
        Arrays.parallelSort(arr);
        for(int value : arr){
            System.out.print(value + " ");
        }

    }
}
