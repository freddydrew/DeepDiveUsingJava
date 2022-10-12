public class Main {

    //*This code is from the BroCode tutorial on YouTube*/
    //O(NLogN), logarithmic quasilinear time
    //stable algorithm
    //not an in-place algorithm so space could be a concern
    //divide and conquer algorithm

    public static void mergeSort(int[] arr){
        //cache array length
        int len = arr.length;

        //base case
        if (len <= 1){
            return;
        }

        //split arrays
        int midPoint = len/2;
        int[] leftArr = new int[midPoint];
        int[] rightArr = new int[len - midPoint];

        //Split elements by copying elements from original array to left and right arrays
        int i = 0;
        int j = 0;
        for (; i < len; i++){
            if (i < midPoint){
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }

        //recursive call to this method to keep splitting arrays
        mergeSort(leftArr);
        mergeSort(rightArr);

        //now call merge once everything is split
        merge(leftArr,rightArr,arr);

    }

    /*helper method used when everything is split*/
    private static void merge(int[] leftArr, int[] rightArr, int[] arr){
        //cache the size of the left and right arrays
        int leftLen = arr.length/2;
        int rightLen = arr.length - leftLen;
        int l = 0 , r = 0, i = 0; //indices to track position in each array

        //check conditions for merging
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
        /*for one element left over that cant be compared to anything because it's not in a pair*/
        //for the lonely left array element
        while (l < leftLen){
            arr[i] = leftArr[l];
            i++;
            l++;
        }
        //for the lonely right array element
        while (r < rightLen){
            arr[i] = rightArr[r];
            i++;
            r++;
        }

    }

    public static void main(String args[]){

        int[] intArray = {20,35,-15,7,55,1,-22};
        mergeSort(intArray);
        for (int item : intArray){
            System.out.println(item);
        }

    }
}
