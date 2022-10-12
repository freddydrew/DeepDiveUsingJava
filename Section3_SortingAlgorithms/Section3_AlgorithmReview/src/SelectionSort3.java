public class SelectionSort3 {

    public static void selectionSort(int[] arr){
        for (int i = arr.length - 1; i>0; i--){
            int max = 0;
            for(int j = 0; j<= i; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
    }


    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        selectionSort(intArray);
        for (int item : intArray){
            System.out.print(item + " ");
        }
    }
}
