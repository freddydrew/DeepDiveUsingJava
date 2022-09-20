public class Main {

    public static void countingSort(int[] arr, int min, int max){

        //keeping track of the count with this histogram
        int[] countArr = new int[(max-min)+1];

        //iterate through array and count frequency of each value
        for (int value: arr){
            int slotIdxOfValueInHistogram = value - min;
            countArr[slotIdxOfValueInHistogram]++; //each count starts at zero, we increment
        }

        //loop over the count array, get the count and put the numbers into the input array
        int inputArrayIndex = 0;
        for (int i = 0; i < countArr.length; i++ ){
            while (countArr[i] > 0){
                /*add the minimum to get the actual number of given frequency. so if countArr[0] = 4 and the minimum
                * is 3, that means the number three is repeated 4 times. Each countArray element counts the next
                * integer so adding the min value to index "i" gets the number that you've kept a count of.*/
                arr[inputArrayIndex] = i + min;
                inputArrayIndex++; //move up one in the input array
                countArr[i]--; //decrement the count so the while loop is not infinite
            }
        }
    }

    public static void main(String args[]){
        int[] intArray = {2,5,9,8,2,8,7,10,4,3};
        countingSort(intArray,2,10);
        for (int item : intArray){
            System.out.println(item);
        }
    }
}
