public class Main {

    public static void main(String args[]){
        int[] intArray = {20,35,-15,7,55,1,-22};


        for (int firstUnsortedIdx = 1; firstUnsortedIdx < intArray.length; firstUnsortedIdx++){
            int newElement = intArray[firstUnsortedIdx]; //to be inserted
            int sortedIdx;
            for (sortedIdx = firstUnsortedIdx; sortedIdx > 0 && intArray[sortedIdx - 1] > newElement; sortedIdx--){
                intArray[sortedIdx] = intArray[sortedIdx - 1];
            }
            intArray[sortedIdx] = newElement;
        }


        for (int item : intArray){
            System.out.println(item);
        }

    }
}
