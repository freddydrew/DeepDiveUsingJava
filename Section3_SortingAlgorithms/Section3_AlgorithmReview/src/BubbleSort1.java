public class BubbleSort1 {

    //O(N^2) quadratic, think nested for loops
    //in-place operation
    //stable sort
    //horrible for long arrays
    public static void bubbleSort(int[] arr){
        for (int i = arr.length -1; i > 0; i--){
            for (int j = 0; j < i; j ++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
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
