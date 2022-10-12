public class BubbleSort3 {

    public static void bubbleSort(int[] arr){
        for(int i = arr.length -1;i>0;i--){
            for(int j = 1;j<=i;j++){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String args[]){
        int[] intArray = {4725,4586,1330,8792,1594,5729};
        bubbleSort(intArray);
        for (int item : intArray){
            System.out.print(item + " ");
        }
    }
}
