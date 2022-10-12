public class Main {
    public static void main(String args[]){
        String[] strings = new String[]{"abccba","Was it a car or a cat I saw?","I did, didI?","hello","Don't nod"};

        for (String phrase : strings){
            SLLStack<Character> stack = new SLLStack<>();
            ArrayQueue<Character> queue = new ArrayQueue<>();
            phrase = phrase.toLowerCase();
            for(int i = 0; i < phrase.length(); i++){
                Character letter = phrase.charAt(i);
                if (Character.isLetter(letter)){
                    stack.push(letter);
                    queue.enqueue(letter);
                }
            }

            while(!stack.isEmpty()){
                if(queue.dequeue() != stack.pull()){
                    System.out.println(phrase + " is NOT a palindrome");
                    break;
                }
            }
            if (stack.isEmpty()){
                System.out.println(phrase + " IS a palindrome");
            }
        }
    }
}
