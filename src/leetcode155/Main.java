package leetcode155;

import java.util.LinkedList;

/**
 * @author ohm
 */
public class Main {
}
class MinStack {

    private LinkedList<Integer> elements;
    private LinkedList<Integer> minElements;

    /** initialize your data structure here. */
    public MinStack() {
        elements = new LinkedList<>();
        minElements = new LinkedList<>();
    }

    public void push(int x) {
        elements.push(x);
        if(minElements.isEmpty())
            minElements.push(x);
        else
            minElements.push(minElements.peek() < x ? minElements.peek() : x);
    }

    public void pop() {
        elements.pop();
        minElements.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return minElements.peek();
    }
}