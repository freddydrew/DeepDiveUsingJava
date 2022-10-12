public class SimpleHashtable <T>{

    private StoredInfo<T>[] table;

    public SimpleHashtable(){
        this.table =  new StoredInfo[10];
    }

    public void put(String key, T item){
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)){
            int stopIdx = hashedKey;
            if (hashedKey == table.length - 1){
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey != stopIdx){
              hashedKey = (hashedKey + 1) % table.length;
              }
        }
        table[hashedKey] = new StoredInfo<T>(key,item);
    }

    public Object get(String key){
        int hashedKey = findKey(key);
        if (table[hashedKey] == null){
            System.out.println("nothing here");
            return null;
        } else {
            return table[hashedKey].value;
        }
    }

    public StoredInfo<T> remove(String key){
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }

        StoredInfo<T> tmp = table[hashedKey];
        table[hashedKey] = null;
        StoredInfo<T>[] oldTable = table;
        table = new StoredInfo[oldTable.length];
        for (int i = 0; i < oldTable.length; i++){
            if (oldTable[i] != null){
                this.put(oldTable[i].key,oldTable[i].value);
            }
        }
        return tmp;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if (table[hashedKey] != null && table[hashedKey].key.equals(key)){
            return hashedKey;
        }

        if (occupied(hashedKey)){
            int stopIdx = hashedKey;
            if (hashedKey == table.length - 1){
                hashedKey = 0;
            } else {
                hashedKey ++;
            }

            while(hashedKey != stopIdx && !table[hashedKey].key.equals(key) && table[hashedKey] != null){
                hashedKey = (hashedKey + 1) % table.length;
            }
        }
        if (table[hashedKey].key.equals(key) && table[hashedKey] != null) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private int hashKey(String key){
        return key.length() % table.length;
    }

    private boolean occupied(int idx){
        return table[idx] != null;
    }

    public void printTable(){
        for (StoredInfo item : table){
            if (item == null){
                System.out.println("<key:value>" + "\t" + "empty" + "\t" + "empty");
            } else {
                System.out.println("<key:value>" + "\t" + item.key + "\t" + item.value);
            }
        }
    }
}
