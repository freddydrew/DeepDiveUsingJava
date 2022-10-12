public class ShellSort3 {

    public static void shellSort(int[] arr){
        for (int gap = arr.length/2; gap>0; gap/=2){
            for (int i = gap;i< arr.length;i++){
                int tmp = arr[i];
                int j = i;
                while (j>=gap && arr[j-gap] > tmp){
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = tmp;
            }
        }


    }

    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        shellSort(intArray);
        for (int item : intArray){
            System.out.print(item + " ");
        }
    }
}
