public class Challenge3_RadixSort {

    //O(N), not in-place, stable
    public static void radixSort(String[] arr){
        //max value on the array
        int max = arr[0].length();
        for (String value : arr){
            if (value.length() > max){
                max = value.length();
            }
        }

        //calc the sort function for each digit position of the max value
        for(int letter = max - 1; letter >= 0; letter--){
            sortAtRadix(arr,letter);
        }
    }

    private static void sortAtRadix(String[] arr, int letter){
        int[] countArr = new int[26]; //create the count array

        /*getting the remainder of the division and using that as the idx to the count array
         * this acts as a bin for the values*/
        for(int i = 0; i < arr.length; i++){
            String curr = arr[i];
            int countIdx = curr.charAt(letter) -'a';
            countArr[countIdx]++;
        }

        /*adjust the count to show how many values at that position are less than or equal to that index*/
        for(int j = 1; j < 26; j++){
            countArr[j] += countArr[j-1];
        }

        /*sort based on value at radix*/
        String[] tmp = new String[arr.length]; //tmp output array
        for(int k = arr.length - 1; k >=0 ;k--){ //increment by input array index
            String curr = arr[k];
            int countIdx = curr.charAt(letter) -'a'; //get the count index
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
        String[] arr = new String[]{"bcdef","dbaqc","abcde","omadd","bbbbb"};
        radixSort(arr);

        for (String word : arr){
            System.out.print(word + " ");
        }

    }
}
