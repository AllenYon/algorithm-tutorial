package io.github.alin.algorithm.other;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意 两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                switch (t) {
                    case "+": {
                        stack.push((b+a) + "");
                        break;
                    }
                    case "-": {
                        stack.push((b-a) + "");
                        break;
                    }
                    case "*": {
                        stack.push((b*a) + "");
                        break;
                    }
                    case "/": {
                        stack.push((b/a) + "");
                        break;
                    }
                }
            } else {
                stack.push(t);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int evalRPNV2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (t) {
                    case "+": {
                        stack.push(b+a);
                        break;
                    }
                    case "-": {
                        stack.push(b-a);
                        break;
                    }
                    case "*": {
                        stack.push(b*a);
                        break;
                    }
                    case "/": {
                        stack.push(b/a);
                        break;
                    }
                }
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
