public class Main {

    public static void swapLast(int[] arr, int target, int last){
        if (target == last){
            return;
        }
        int tmp = arr[last];
        arr[last] = arr[target];
        arr[target] = tmp;
    }

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};
        for (int winEnd = intArray.length-1; winEnd > 0; winEnd--){
            int largest = 0; //storing the current largest element in the unsorted partition
            for (int winStart = 1; winStart <= winEnd; winStart ++){
                if (intArray[winStart] > intArray[largest]){
                    largest = winStart;
                }
            }
            swapLast(intArray,largest,winEnd); //the ole swapperoo
        }


        for (int item : intArray){
            System.out.println(item);
        }

    }
}
