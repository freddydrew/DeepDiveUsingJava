public class ShellSort2 {

    //O(N^2), in-place, stable
    public static void shellSort(int[] arr){
        for(int gap = arr.length/2;gap>0;gap/=2){ //shrink the gap each loop
            for (int i = gap; i < arr.length; i++){ //slide the window over by 1 each loop
                int j = i;
                int tmp = arr[i]; //thing to insert
                if (j>=gap && arr[j-gap] > tmp){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = tmp; //insert it after things were slided over
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
