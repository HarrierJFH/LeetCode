package leetcode;

import java.util.Arrays;

public class Problem155 {

    private static class MinStack {

        private static class IntStack {
            int size = 0;
            int capacity = 16;
            int[] ints = new int[capacity];

            public void push(int x) {
                if (size == capacity) {
                    capacity *= 2;
                    ints = Arrays.copyOf(ints, capacity);
                }
                ints[size++] = x;
            }

            public int pop() {
                if (size > 0) {
                    return ints[--size];
                }
                throw new IndexOutOfBoundsException();
            }

            public int top() {
                if (size > 0) {
                    return ints[size - 1];
                }
                throw new IndexOutOfBoundsException();
            }

        }

        public MinStack() {

        }

        private IntStack intStack = new IntStack();
        private IntStack minStack = new IntStack();

        public void push(int x) {
            intStack.push(x);
            if (minStack.size == 0 || x <= minStack.top()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (intStack.size > 0) {
                int val = intStack.pop();
                if (val == getMin()) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            return intStack.top();
        }

        public int getMin() {
            return minStack.top();
        }
    }

}
