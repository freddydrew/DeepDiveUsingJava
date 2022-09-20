public class Main {

    /*swaps arr elements at index i and j*/
    private static void swap(int[] arr, int i, int j){
        if (i == j){return;}
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*this bubble sort will sort them in ascending order, left to right*/
    /*it will sort the array by swapping adjacent elements as it traverses the array*/
    /*with each traversal of the array it becomes more sorted*/
    /*O(N^2) complexity, in-place algorithm, stable sort*/
    public static void bubbleSort(int[] arr){
        /*Unsorted partition starts at the end of the array and shrinks going back toward the front*/
        /*It will shrink wth each traversal of the array*/
        for (int lastUnsortedIdx = arr.length - 1; lastUnsortedIdx > 0; lastUnsortedIdx--){
            /*this nested loop starts working on the unsorted partition moving left to right
            it will compare the current unsorted index in the shrinking unsorted partition to its adjacent value
            if it's bigger, its swaps*/
            for (int currUnsorted = 0; currUnsorted < lastUnsortedIdx; currUnsorted++){
                if (arr[currUnsorted] > arr[currUnsorted + 1]){
                    swap(arr,currUnsorted,currUnsorted + 1);
                }
            }
        }
    }

    /*traverse the array, find the larges and swap it with the last element*/
    /*O(N^2) complexity, in-place algorithm, Unstable sort*/
    public static void selectionSort(int[] arr){
        /*same concept as bubble sort, the unsorted partition shrinks starting at the end and finishing at the front*/
        for (int lastUnsortedIdx = arr.length - 1; lastUnsortedIdx > 0; lastUnsortedIdx--){
            int currLargest = 0; //assign current largest to the first index of the array
            /*start the sorting at the 2nd index and compare values each loop*/
            /*after traversing the unsorted partition, it finds the current largest value and does the swap*/
            for (int currUnsorted = 1; currUnsorted <= lastUnsortedIdx; currUnsorted++){
                if (arr[currUnsorted] > arr[currLargest]){
                    currLargest = currUnsorted;
                }
            }
            /*swap the largest value in unsorted partition with the left most value of the sorted partition*/
            /*the left most value of sorted partition expands with the outer for loop*/
            swap(arr,currLargest,lastUnsortedIdx);
        }
    }

    /*traverse the array, find where in sorted partition to insert current value*/
    /*O(N^2) complexity, in-place algorithm, stable sort*/
    public static void insertionSort(int[] arr){
        /*grows the sorted partition from the start of the array, by default the first index at t = 0, is sorted*/
        /*outer loop will move from left to right, take the current element, and with inner loop compare it to elements
        * of the sorted partition. It slides the values of the sorted partition over until it finds the correct spot
        * for the element its trying to insert, hence the name*/
        for (int currUnsortedIdx = 1; currUnsortedIdx < arr.length; currUnsortedIdx++){
            int newElement = arr[currUnsortedIdx]; //this will be the new element in the sorted partition
            int lastSortedIdx; //we need this outside of the for loop below
            for (lastSortedIdx = currUnsortedIdx; lastSortedIdx > 0 && arr[lastSortedIdx - 1] > newElement;lastSortedIdx --){
                arr[lastSortedIdx] = arr[lastSortedIdx - 1];
            }
            /*when the inner for loop can no longer slide the values over because the condition is not met, it inserts
            * the new element into the sorted partition. From here the outer for loop increments by 1, and we restart
            * the entire process.*/
            arr[lastSortedIdx] = newElement;
        }
    }

    /*prints arrays with indicator of sorting algorithm*/
    public static void printArr(int[] arr, String s){
        System.out.print(s + ": ");
        for (int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){

        /*EVERYTHING IS COPY PASTA!!!*/
        /*bubble sort test*/
        int[] intArray1 = {20,35,-15,7,55,1,-22}; //test array, same as in class examples
        printArr(intArray1,"Unsorted     ");
        bubbleSort(intArray1);
        printArr(intArray1,"Bubble Sorted");

        /*selection sort test*/
        int[] intArray2 = {20,35,-15,7,55,1,-22}; //test array, same as in class examples
        printArr(intArray2,"Unsorted        ");
        selectionSort(intArray2);
        printArr(intArray2,"Selection Sorted");

        /*insertion sort test*/
        int[] intArray3 = {20,35,-15,7,55,1,-22}; //test array, same as in class examples
        printArr(intArray3,"Unsorted        ");
        insertionSort(intArray3);
        printArr(intArray3,"Insertion Sorted");
    }
}
