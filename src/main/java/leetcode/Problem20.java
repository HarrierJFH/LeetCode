package leetcode;

public class Problem20 {

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        } else if (length == 0) {
            return true;
        }
        int stackSize = length / 2;
        char[] stack = new char[stackSize];
        int top = 0;
        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    if (top == stackSize) {
                        return false;
                    }
                    stack[top++] = c;
                    break;
                case ')':
                    if (top == 0) {
                        return false;
                    }
                    if (stack[--top] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (top == 0) {
                        return false;
                    }
                    if (stack[--top] != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (top == 0) {
                        return false;
                    }
                    if (stack[--top] != '{') {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return top == 0;
    }

}
