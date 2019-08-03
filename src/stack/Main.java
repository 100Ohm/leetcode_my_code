package stack;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        Stack s = new Stack(10);
        Stack s2 = new Stack(new int[]{19, 17, 15,28, 16, 41, 22, 13, 30, 62});
        s.push(19);
        s.push(17);
        s.push(15);
        s.push(28);
        s.push(16);
        s.push(41);
        s.push(22);
        s.push(13);
        s.push(30);
        s.push(62);
        System.out.println(Arrays.toString(s.elements));
        for (int i : s ){
            System.out.println(i);
        }
        for (int i : s2 ){
            System.out.println(i);
        }
    }

    static class Stack implements Iterable<Integer>{//大根堆
        int p = - 1;//最后一个元素的下标
        int[] elements;

        public Stack(int capacity) {
            elements = new int[capacity];
        }

        public Stack(int[] e) {//原地建堆
            this.elements = e;
            p = e.length - 1;
            int firstNotChild = p/2 +1;//(p+1+1)/2-1
            for (int i = firstNotChild; i >= 0; i--) {
                shiftDown(i);
            }
        }

        public int pop() {//将最大的元素弹出
            if(p < 0)
                throw new RuntimeException("no element");
            int big = elements[0];
            elements[0] = elements[p--];
            shiftDown(0);
            return big;
        }

        public void push(int e) {//将元素插入堆
            if(p == elements.length - 1)
                throw new RuntimeException("full heap");
            elements[++p] = e;
            shiftUp(p);
        }

        private void shiftUp(int i) {//将下标为i的元素向上调整一下
            int parent = (i - 1) / 2;
            while(parent >= 0) {
                if(elements[i] <= elements[parent])
                    break;
                swap(parent, i);
                i = parent;
                parent = (i - 1) / 2;
            }
        }

        private void shiftDown(int i) {//将下标为i的元素向下调整一下
            int left = (i + 1) * 2 - 1;
            int right = (i + 1) * 2;
            while(left <= p){
                if(right <= p) {
                    if (elements[i] >= elements[left] && elements[i] >= elements[right])
                        break;
                } else {
                    if (elements[i] >= elements[left])
                        break;
                }
                int max = max(left, right);
                swap(max, i);
                i = max;
                left = (i + 1) * 2 - 1;
                right = (i + 1) * 2;
            }
        }

        private void swap(int a, int b) {
            int tmp = elements[b];
            elements[b] = elements[a];
            elements[a] = tmp;
        }

        private int min(int a, int b) {
            if(a > p) {
                return b;
            } else if(b > p) {
                return a;
            }
            return elements[a] > elements[b] ? b : a;
        }

        private int max(int a, int b) {
            if(a > p) {
                return b;
            } else if(b > p) {
                return a;
            }
            return elements[a] > elements[b] ? a : b;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return p >= 0;
                }

                @Override
                public Integer next() {
                    return pop();
                }
            };
        }
    }
}
