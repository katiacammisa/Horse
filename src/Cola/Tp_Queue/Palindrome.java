package Cola.Tp_Queue;

import Queue.DynamicQueue;
import Queue.StaticQueue;
import Stack.DynamicStack;

public class Palindrome {

    private DynamicStack<Character> stack;
    private DynamicQueue<Character> queue;

    public Palindrome(){
        stack = new DynamicStack<Character>();
        queue = new DynamicQueue<Character>();
    }

    public boolean isPalindrome(String text){

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
            queue.enqueue(text.charAt(i));
        }

        for (int i = 0; i < text.length() ; i++) {
            if(stack.peek() == queue.peek()){
                stack.pop();
                queue.dequeue();
            } else {
                return false;
            }
        }

        return true;
    }
}
