import java.util.LinkedList;

public class HashMapImp {

    LinkedList<Entry>[] hashMap;
    int size;

    public HashMapImp(){
        hashMap = new LinkedList[2];
        size = 0;
    }

    public void put(Key k, Value v){
        if (size >= hashMap.length){
            reSize();
        }

        int idx = getIndex(k) % hashMap.length;
        if(hashMap[idx] == null){ //this if statement is when there is no collision
            hashMap[idx] = new LinkedList<>();
            hashMap[idx].add(new Entry(k,v));
            size += 1;
            return;
        } else { //if this code block is executing, that means there's a collision
            for(Entry entry : hashMap[idx]){
                if(entry.Key.equals(k)){
                    entry.Value = v;
                    return;
                }
            }

            hashMap[idx].add(new Entry(k,v));
            size += 1;
            return;
        }
    }

    public Value get(Key k){
        int idx = getIndex(k) % hashMap.length;
        if (hashMap[idx] == null){
            return null;
        }

        for(Entry entry : hashMap[idx]){
            if(entry.Key.equals(k)){
                return entry.Value;
            }
        }
        return null;
    }

    public void remove(Key k){
        if (k == null){
            return;
        }
        int idx = getIndex(k) % hashMap.length;
        if (hashMap[idx] == null){
            return;
        }

        Entry toRemove = null;
        for (Entry entry : hashMap[idx]){
            if (entry.Key.equals(k)){
                toRemove = entry;
            }
        }
        if (toRemove == null){
            return;
        }
        hashMap[idx].remove(toRemove);
        size --;
    }

    public boolean containsKey(Key k){
        if (k == null){
            return false;
        }

        int idx = getIndex(k) % hashMap.length;
        for (Entry entry : hashMap[idx]){
            if (entry.Key.equals(k)){
                return true;
            }
        }

        return false;
    }

    public void reSize(){
        LinkedList<Entry>[] tmp = hashMap;
        hashMap = new LinkedList[size * 2];
        size = 0;

        for (int i = 0; i < tmp.length; i++){
            for (Entry entry : tmp[i]){
                this.put(entry.Key,entry.Value);
            }
        }
    }

    public int getIndex(Key k){
        return k.hashCode();
    }

    public int getSize(){
        return size;
    }

}
