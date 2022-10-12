public class InsertionSort2 {

    //O(N^2), in-place, stable
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int tmp = arr[i]; //set aside value to be inserted
            int j = i;
            /*slide all values greater than tmp over*/
            while(j > 0 && arr[j-1] > tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        insertionSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }
    }
}
