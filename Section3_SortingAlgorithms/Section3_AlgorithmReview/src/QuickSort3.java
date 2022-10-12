public class QuickSort3 {


    public static void quickSort(int[] arr, int start, int end){
        if (end <= start){return;}

        int pivot = part(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);

    }

    private static int part(int[] arr, int start, int end){
        int pivot = arr[end];

        int i = start - 1;
        for(int j = start;j<end; j++){
            if(arr[j]<pivot){
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
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        quickSort(arr,0, arr.length - 1);
        for (int value: arr){
            System.out.print(value + " ");
        }
    }
}
