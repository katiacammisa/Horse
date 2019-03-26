package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackDTest{

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
        stack.push(5);
        stack.push(8);
        stack.push(13);
        stack.pop();
        System.out.println(stack.peek());
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void size() {
        stack.push(5);
        stack.push(8);
        stack.push(13);
        System.out.println(stack.size());
    }

    @Test
    public void empty() {
    }

    @Test
    public void push1() {
    }

    @Test
    public void pop1() {
    }

    @Test
    public void size1() {
    }
}