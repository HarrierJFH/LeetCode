package leetcode;

import util.UtilsKt;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

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
        FizzBuzz fizzBuzz = new FizzBuzz();
        int n = 10000000;
        UtilsKt.timeCostCompare(() -> fizzBuzz.fizzBuzz2(n), () -> fizzBuzz.fizzBuzz(n), 1);
        UtilsKt.timeCostCompare(() -> fizzBuzz.fizzBuzz(n), () -> fizzBuzz.fizzBuzz2(n), 1);
    }

}
