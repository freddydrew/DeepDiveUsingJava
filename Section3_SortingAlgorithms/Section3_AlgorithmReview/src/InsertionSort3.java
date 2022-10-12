public class InsertionSort3 {

    public static void insertionSort(int[] arr){
        for (int i = 1; i< arr.length;i++){
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1]>tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }

    }

    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        insertionSort(intArray);
        for (int item : intArray){
            System.out.print(item + " ");
        }
    }
}
