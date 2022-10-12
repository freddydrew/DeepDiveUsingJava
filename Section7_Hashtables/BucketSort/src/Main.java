import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void bucketSort(int[] arr){
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++){
            buckets[hash(arr[i])].add(arr[i]);
        }

        for (List bucket : buckets){
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++){
            for (int value: buckets[i]){
                arr[j++] = value;
            }
        }
    }

    private static int hash(int val){
        return val / 10;
    }

    public static void main(String args[]){
        int[] arr = new int[]{56,23,57,99,12,3,54,33,16};
        System.out.println();
        bucketSort(arr);
        System.out.println();

    }
}
