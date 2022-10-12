public class Main {

    public static int binarySearch(int[] arr, int value){
        int max = arr.length - 1;
        int min = 0;

        while (min < max){
            int middle = (max - min)/2 + min;
            System.out.println("Current index = " + middle);
            int item = arr[middle];
            if (item == value){
                return middle;
            } else if (item > value) {
                max = middle - 1;
            } else if (item < value){
                min = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] arr = new int[100];
        int k = 0;
        while (k < arr.length){
            arr[k] = k;
            k++;
        }
        System.out.println(binarySearch(arr,42));
        System.out.println();
    }

}
