import java.util.Hashtable;

public class Main {

    public static void main(String args[]){

        Hashtable<String,String> table = new Hashtable<>(10);//change size to 10 rather than 11
        table.put("100","Spongebob");
        table.put("123","Patrick");
        table.put("321","Sandy");
        table.put("555","Squidward");
        table.put("777","Gary");

        for(String key : table.keySet()) {
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        }
    }
}
