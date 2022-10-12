import java.util.*;

public class Main2 {

    public static void main(String args[]){
        List<Integer> L = new LinkedList<>();
        L.add(55);
        L.add(61);
        L.add(10);
        L.add(55);
        L.add(12);
        L.add(43);
        L.add(9);
        L.add(10);

        Hashtable<Integer,Integer> table = new Hashtable<>();
        ListIterator<Integer> iterator = L.listIterator();
        ArrayList<Integer> remove = new ArrayList<>();


        while(iterator.hasNext()){
            int value = iterator.next();
            int key = hashcode(value);
            if (table.containsKey(key)){
                remove.add(value);
            } else {
                table.put(key,value);
            }
        }

        for (int value : remove){
            int i = 0;
            for (int num : L){
                if (num == value){
                    L.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }

        System.out.println();

    }

    private static int hashcode(int value){
        return value % 10;
    }
}
