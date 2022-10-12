public class Challenge2_InsertionSort {

    //O(N^2), in-place, stable
    public static void insertionSort(int[] arr, int n){
        if (n <= 1){return;}
        insertionSort(arr,n-1);
        int tmp = arr[n-1]; //set aside value to be inserted
        int j = n-1;
        /*slide all values greater than tmp over*/
        while(j > 0 && arr[j-1] > tmp){
            arr[j] = arr[j-1];
            j--;
        }
        arr[j] = tmp;

    }

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};
        insertionSort(intArray,6);
        for(int val : intArray){
            System.out.print(val + " ");
        }
    }
}
