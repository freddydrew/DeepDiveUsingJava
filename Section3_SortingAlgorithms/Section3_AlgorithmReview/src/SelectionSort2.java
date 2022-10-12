public class SelectionSort2 {

    //O(N^2), in-place, unstable
    public static void selectionSort(int[] arr){
        for (int i = arr.length - 1; i > 0 ; i--){
            int biggest = 0; //idx of biggest
            for (int j = 0; j <= i ; j++){
                if (arr[j] > arr[biggest]){
                    biggest = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = tmp;
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
