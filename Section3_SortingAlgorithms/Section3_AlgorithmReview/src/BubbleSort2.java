public class BubbleSort2 {

    //O(N^2), in-place, stable
    /*outer loop from right to left, inner loop from left to right and intersects outer loop value,
    * if statement checks adjacent values and swaps if needed*/
    public static void bubbleSort(int[] arr){
        for (int i = arr.length -1; i > 0 ; i--){
            for (int j = 1; j <= i ; j++){
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        bubbleSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }

    }
}
