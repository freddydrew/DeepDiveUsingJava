public class Main {

    public static void quickSort(int[] arr, int start, int end){
    //base case
    if (end <= start){
        return;
    }
    int pivot = partition(arr,start,end);
    quickSort(arr,start,pivot - 1); //invoke quickSort on left partition
    quickSort(arr, pivot + 1, end); //invoke quickSort on right partition
    }

    //helper function to quickSort
    //returns location of pivot
    //sorts array and finds pivot
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;
        //find the values less than the pivot, put them on the left
        for(int j = start; j <= end - 1; j++){
            if (arr[j] < pivot){
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        //find the values greater than the pivot, put them on the right
        i++;
        int tmp = arr[i];
        arr[i] = arr[end];
        arr[end] = tmp;

        return i;
    }

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};
        quickSort(intArray,0, intArray.length-1);
        for (int item : intArray){
            System.out.println(item);
        }

    }
}
