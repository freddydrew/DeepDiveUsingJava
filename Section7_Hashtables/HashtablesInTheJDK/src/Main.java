import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String args[]){

        /*can only have one value per key*/
        Map<String,String> hashtable = new HashMap<>();


        hashtable.put("Drew","Freddy R.");
        hashtable.put("Drew","Chris J.");
        hashtable.put("Drew","Laurie");
        hashtable.put("Drew","Chris T.");
        hashtable.put("Drew","Freddy C.");
        hashtable.put("Drew","Ivy");

//        Iterator<String> iterator = hashtable.values().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        hashtable.forEach((k,v) -> System.out.println("key: " + k + ", Value: " + v));
        System.out.println(hashtable.containsKey("Drew"));
        System.out.println(hashtable.get("Drew"));
    }

}
