public class Main {
    public static void main(String args[]){
//        SLLStack<String> stack = new SLLStack<>("Freddy");
//        stack.push("Drew");
//        stack.push("Derf");
//        stack.push("Werd");
//        stack.push("Dalia");
//        stack.push("Yan");
//        stack.pop();
//        stack.print();
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.search("Freddy"));

        String[] strings = new String[]{"abccba","Was it a car or a cat I saw?","I did, didI?","hello","Don't nod"};

        for(String phrase : strings){
            SLLStack<Character> stack = new SLLStack<>();
            String phraseLower = phrase.toLowerCase();
            String phraseCleaned = "";
            for (int i = 0; i < phraseLower.length(); i++){
                char letter = phraseLower.charAt(i);
                if(Character.isLetter(letter)){
                    stack.push(letter);
                    phraseCleaned += letter;
                }
            }
            for (int i = 0; i < phraseCleaned.length(); i++){
                if (phraseCleaned.charAt(i) != stack.pop()){
                    System.out.println(phrase + " is NOT a palindrome!");
                    break;
                }
            }
            if (stack.isEmpty()){
                System.out.println(phrase + " IS a palindrome!");
            }
        }
    }
}
