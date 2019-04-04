package Cola.Tp_Queue;

import Queue.DynamicQueue;
import Stack.DynamicStack;

public class Palindrome {

    private static DynamicStack<Character> stack;
    private static DynamicQueue<Character> queue;

    public static boolean isPalindrome(String text){

        stack = new DynamicStack<Character>();
        queue = new DynamicQueue<Character>();

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
