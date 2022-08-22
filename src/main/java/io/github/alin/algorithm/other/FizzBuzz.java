package io.github.alin.algorithm.other;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> r = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            r.add(a(i));
        }
        return r;
    }

    private String a(int n) {
        if (n % 5 == 0 && n % 3 == 0) {
            return "FizzBuzz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        }
        return n + "";
    }

}
