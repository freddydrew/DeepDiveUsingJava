public class MergeSort4 {

    public static void mergeSort(int[] arr){
        int length = arr.length;
        if (length == 1){return;}
        int middle = length/2;
        int[] left = new int[middle];
        int[] right = new int[length-middle];
        int l = 0;
        int r = 0;

        for (int i = 0; i < length; i++){
            if (i < middle){
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
        int i = 0;
        int l = 0;
        int r = 0;

        while(l < left.length && r < right.length){
            if (left[l] < right[r]){
                arr[i] = left[l];
                i++;
                l++;
            } else {
                arr[i] = right[r];
                i++;
                r++;
            }
        }

        while (l < left.length){
            arr[i] = left[l];
            l++;
        }
        while(r < right.length){
            arr[i] = right[r];
            r++;
        }

    }

    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        mergeSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }
    }

}
