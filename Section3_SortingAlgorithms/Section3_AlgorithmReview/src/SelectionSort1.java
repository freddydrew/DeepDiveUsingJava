public class SelectionSort1 {

    //O(N^2) quadratic, in-place, unstable
    public static void selectionSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            int currLargest = 0; //this is the INDEX NOT THE VALUE
            for (int j = 1; j <= i; j++){
                if (arr[j] > arr[currLargest]){
                    currLargest = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[currLargest];
            arr[currLargest] = tmp;
        }
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        selectionSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }
    }
}
