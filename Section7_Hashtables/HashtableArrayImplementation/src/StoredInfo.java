public class StoredInfo <T>{
    public String key;
    public T value;

    public StoredInfo(String k, T v){
        this.key = k;
        this.value = v;
    }
}
