public class CountingSort2 {

    public static void countingSort(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int value : arr){
            if (value < min){
                min = value;
            }
            if (value > max){
                max = value;
            }
        }
        int[] countArr = new int[(max-min)+1];
        for(int value : arr){
            int countIdx = value - min;
            countArr[countIdx]++;
        }

        int j = 0;
        for (int i = 0;i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[j] = i + min;
                j++;
                countArr[i]--;
            }
        }
    }

    public static void main(String args[]){
        int[] intArray = {2,5,9,8,2,8,7,10,4,3};
        countingSort(intArray);
        for (int item : intArray){
            System.out.println(item);
        }
    }


}
