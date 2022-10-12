public class Main {
    public static void main(String args[]){
//        SimpleHashtable hashtable = new SimpleHashtable();
//        hashtable.put("First","Fred");
//        hashtable.put("Last","Tom");
//        hashtable.put("Middle","Jerry");
//        hashtable.put("First","Drew");
//        hashtable.put("Last","Derf");
//        hashtable.put("Middle","Dalia");
//        hashtable.printTable();
//        System.out.println(hashtable.get("First"));
//        System.out.println(hashtable.get("First"));
//        hashtable.remove("First");
//        hashtable.printTable();
//        System.out.println(hashtable.get("Middle"));
//        System.out.println();
//        hashtable.printTable();
//


        /*chained hashtable*/
        ChainedHashtable<String> chainedHashtable = new ChainedHashtable<>();
        chainedHashtable.put("First","Fred");
        chainedHashtable.put("Last","Tom");
        chainedHashtable.put("Middle","Jerry");
        chainedHashtable.put("First","Drew");
        chainedHashtable.put("Last","Derf");
        chainedHashtable.put("Middle","Dalia");
        chainedHashtable.printHashtable();
//        chainedHashtable.remove("Middle");
//        chainedHashtable.printHashtable();
//        chainedHashtable.remove("Middle");
//        chainedHashtable.printHashtable();
    }
}
