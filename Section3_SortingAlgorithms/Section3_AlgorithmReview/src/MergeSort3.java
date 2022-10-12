public class MergeSort3 {

    public static void mergeSort(int[] arr){
        int length = arr.length;
        if (length == 1){return;}

        int middle = length/2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];
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

    private static int[] merge(int[] arr, int[] left, int[] right){
        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0;
        int l = 0;
        int r = 0;

        while(l < leftLen && r < rightLen){
            if(left[l] < right[r]){
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

        while(r < rightLen){
            arr[i] = right[r];
            i++;
            r++;
        }

        return arr;
    }



    public static void main(String args[]){
        int[] arr = new int[]{5,4,6,8,2,8,6,5,4,8,11,36,32,75,12};
        mergeSort(arr);
        for (int value : arr){
            System.out.print(value + " ");
        }

    }
}
