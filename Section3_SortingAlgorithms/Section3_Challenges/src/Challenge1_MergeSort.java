public class Challenge1_MergeSort {
    public static void mergeSort(int[] arr){
        int length = arr.length;
        int midpoint = length/2;
        if (length == 1){
            return;
        }
        int[] left = new int[midpoint];
        int[] right = new int[length - midpoint];
        int l = 0;
        int r = 0;
        for (int i = 0; i < length; i++){
            if (i < midpoint){
                left[l] = arr[i];
                l++;
            } else {
                right[r] = arr[i];
                r++;
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }

    private static void merge(int[] arr, int[] left, int[] right){
        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0;
        int l = 0;
        int r = 0;
        while(l < leftLen && r < rightLen){
            if (left[l] > right[r]){
                arr[i] = left[l];
                i++;
                l++;
            } else {
                arr[i] = right[r];
                i++;
                r++;
            }
        }
        while(l < leftLen){
            arr[i] = left[l];
            i++;
            l++;
        }
        while (r < rightLen){
            arr[i] = right[r];
            i++;
            r++;
        }
    }

    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        mergeSort(intArray);
        for (int item : intArray){
            System.out.println(item);
        }
    }
}
