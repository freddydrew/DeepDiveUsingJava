import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable <T>{

    private LinkedList<StoredInfo>[] hashtable;

    public ChainedHashtable(){
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++){
            hashtable[i] = new LinkedList<StoredInfo>();
        }
    }

    public void put(String key, T value){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredInfo<>(key,value));
    }

    public T get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredInfo> iterator = hashtable[hashedKey].listIterator();
        StoredInfo<T> item;
        while(iterator.hasNext()){
            item = iterator.next();
            if (item.key.equals(key)){
                return item.value;
            }
        }
        return null;
    }

    public T remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredInfo> iterator = hashtable[hashedKey].listIterator();
        StoredInfo<T> itemToRemove = null;
        int idx = 0;
        while (iterator.hasNext()){
            itemToRemove = iterator.next();
            if (itemToRemove.key.equals(key)){
                break;
            }
            idx++;
        }

        if (itemToRemove == null){
            return null;
        } else {
            hashtable[hashedKey].remove(idx);
            return itemToRemove.value;
        }
    }

    private int hashKey(String key){
        return Math.abs(key.length()) % hashtable.length;
    }

    public void printHashtable(){
        int idx = 0;
        for (LinkedList L : hashtable){
            if (L.isEmpty()){
                System.out.println("Index "+ idx + " is empty");
            } else {
                ListIterator<StoredInfo> iterator = hashtable[idx].listIterator();
                System.out.println("List at " + idx + ": ");
                while (iterator.hasNext()){
                    System.out.print(iterator.next().value + " -> ");
                }
                System.out.println("null");
            }
            idx++;
        }
    }

}
