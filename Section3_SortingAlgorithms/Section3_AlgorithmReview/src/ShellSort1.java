public class ShellSort1 {

    public static void shellSort(int[] arr){

        for (int gap = arr.length/2; gap > 0; gap /= 2){

            for (int i = gap; i < arr.length; i++){
                int tmp = arr[i];
                int j = i;

                while(j >= gap && arr[j-gap] > tmp){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = tmp;
            }
        }
    }
    public static void main(String args[]){
        int[] arr = new int[]{1,5,3,9,4,6,34,5,6};
        shellSort(arr);
        for (int value: arr){
            System.out.print(value + " ");
        }

    }
}
