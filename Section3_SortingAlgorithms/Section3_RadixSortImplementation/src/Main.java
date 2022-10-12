public class Main {

    //O(N), not in-place, stable
    public static void radixSort(int[] arr){
        //max value on the array
        int max = arr[0];
        for (int value : arr){
            if (value > max){
                max = value;
            }
        }

        //calc the sort function for each digit position of the max value
        for(int exp = 1; max/exp > 0; exp *= 10){
            sortAtRadix(arr,exp);
        }
    }

    private static void sortAtRadix(int[] arr, int exp){
        int[] countArr = new int[10]; //create the count array

        /*getting the remainder of the division and using that as the idx to the count array
        * this acts as a bin for the values*/
        for(int i = 0; i < arr.length; i++){
            int countIdx = (arr[i]/exp)%10;
            countArr[countIdx]++;
        }

        /*adjust the count to show how many values at that position are less than or equal to that index*/
        for(int j = 1; j < 10; j++){
            countArr[j] += countArr[j-1];
        }

        /*sort based on value at radix*/
        int[] tmp = new int[arr.length]; //tmp output array
        for(int k = arr.length - 1; k >=0 ;k--){ //increment by input array index
            int countIdx = (arr[k]/exp)%10; //get the count index
            int tmpIdx = countArr[countIdx] - 1; //get the tmp array index
            tmp[tmpIdx] = arr[k];
            countArr[countIdx]--; //don't let it repeat
        }

        /*write to input array*/
        for (int l = 0; l < tmp.length; l++){
            arr[l] = tmp[l];
        }

    }


    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        radixSort(intArray);
        for (int item : intArray){
            System.out.println(item);
        }
    }

}
