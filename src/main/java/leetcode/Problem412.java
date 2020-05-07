package leetcode;

import util.UtilsKt;

import java.util.ArrayList;
import java.util.List;

public class Problem412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        int fizzCount = 0;
        int buzzCount = 0;
        for (int i = 1; i <= n; i++) {
            if (++fizzCount == 3) {
                fizzCount = 0;
                if (++buzzCount == 5) {
                    buzzCount = 0;
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (++buzzCount == 5) {
                buzzCount = 0;
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem412 problem412 = new Problem412();
        int n = 10000000;
        UtilsKt.timeCostCompare(() -> problem412.fizzBuzz2(n), () -> problem412.fizzBuzz(n), 1);
        UtilsKt.timeCostCompare(() -> problem412.fizzBuzz(n), () -> problem412.fizzBuzz2(n), 1);
    }

}
