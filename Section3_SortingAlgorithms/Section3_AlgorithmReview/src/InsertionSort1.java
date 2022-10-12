public class InsertionSort1 {

    public static void insertionSort(int[] arr){
        for (int i = 1 ; i < arr.length; i ++){
            int tmp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > tmp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
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
