package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackDTest {

    StackD<Integer> stack = new StackD<Integer>();

    @Test
    public void push() {
        stack.push(5);
        stack.push(8);
        stack.push(13);
        System.out.println(stack.peek());
    }

    @Test
    public void pop() {
        stack.pop();
        System.out.println(stack.peek());
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void size() {
        System.out.println(stack.size());
    }

    @Test
    public void empty() {
    }
}