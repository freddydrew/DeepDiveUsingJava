public class RadixSort1 {

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int value : arr){
            if(value > max){
                max = value;
            }
        }

        for (int exp = 1; max/exp > 0; exp *= 10){
            sort(arr,exp);
        }
    }

    private static void sort(int[] arr, int exp){
        int[] countArr = new int[10];
        for (int value : arr){
            int countIdx = (value/exp)%10;
            countArr[countIdx]++;
        }

        for(int i = 1; i < countArr.length; i++){
            countArr[i] += countArr[i - 1];
        }

        int[] tmp = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            int countIdx = (arr[i]/exp)%10;
            int tmpIdx = countArr[countIdx] - 1;
            tmp[tmpIdx] = arr[i];
            countArr[countIdx]--;
        }

        for (int i = 0; i < arr.length; i++){
            arr[i] = tmp[i];
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
