public class QuickSort2 {

    public static void quickSort(int[]arr, int start, int end){
        if (end <= start){return;}

        int pivot = split(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr,pivot + 1, end);

    }

    private static int split(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++){
            if (arr[j] < pivot){
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        i++;
        int tmp = arr[end];
        arr[end] = arr[i];
        arr[i] = tmp;
        return i;

    }

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};
        quickSort(intArray,0,intArray.length - 1);
        for (int item : intArray){
            System.out.println(item);
        }

    }

}
