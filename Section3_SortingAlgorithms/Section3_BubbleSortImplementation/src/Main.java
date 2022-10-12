public class Main {

    /*swaps elements i and j in int array arr*/
    public static void swap(int[] arr, int i, int j){

        /*no point in swapping same element*/
        if (i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};
        for (int last = intArray.length - 1; last > 0; last --){
            for (int first = 0; first < last; first ++){
                if (intArray[first] > intArray[first+1]) {
                    swap(intArray, first, first + 1);
                }
            }
        }
        for (int item : intArray){
            System.out.println(item);
        }

    }
}
