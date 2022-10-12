public class CountingSort1 {

    //O(N), not in-place, unstable
    public static void countingSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int val : arr){
            if (val < min){
                min = val;
            }
            if (val > max){
                max = val;
            }
        }

        int[] countArr = new int[(max-min)+1];
        for (int val: arr){
            int IdxOfValCount = val - min;
            countArr[IdxOfValCount]++;
        }

        int j = 0;
        for (int i = 0; i < countArr.length;i++){
            while (countArr[i]>0){
                arr[j] = i + min;
                countArr[i]--;
                j++;
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
