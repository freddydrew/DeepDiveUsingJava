public class MergeSort1 {
    public static void mergeSort(int[] arr){
        int len = arr.length;
        if (len == 1){
            return;
        }

        //finds the arr midpoint, uses this to size left and right arrays
        int midPoint = len/2;
        int[] leftArr = new int[midPoint];
        int[] rightArr = new int[len - midPoint];

        int i = 0; //idx for left array
        int j = 0; //idx for right array

        //split the array with a for loop
        for(;i< len;i++){
            if (i < midPoint){
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }

        //recrusive calls for the two parts of the array
        mergeSort(leftArr);
        mergeSort(rightArr);

        //the helper function that actually does the merging
        mergeHelper(arr,leftArr,rightArr);

    }

    private static int[] mergeHelper(int[] arr, int[] leftArr, int[] rightArr){

        //find the length of the left and right arrays
        int leftLen = arr.length/2;
        int rightLen = arr.length - leftLen;

        //these will track the current index of the three arrays in the following loops
        int i = 0;
        int l = 0;
        int r = 0;

        /*while there's still stuff in the arrays to process, put them back into arr in the correct order*/
        while(l < leftLen && r < rightLen){
            if (leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            } else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        //for odd number of elements in the left array
        while(l < leftLen){
            arr[i] = leftArr[l];
            i++;
            l++;
        }
        //for odd number of elements in the right array
        while(r < rightLen){
            arr[i] = rightArr[r];
            i++;
            r++;
        }

        //return the sorted array
        return arr;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        mergeSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }
    }
}
