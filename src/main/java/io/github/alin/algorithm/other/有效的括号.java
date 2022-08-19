package io.github.alin.algorithm.other;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{"));
    }

    public static boolean isValid(String s) {
        char[] x = s.toCharArray();
        if (x.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < x.length; i++) {
            if (x[i] == '{' || x[i] == '[' || x[i] == '(') {
                stack.push(x[i]);
            }
            if (x[i] == '}') {
                if (stack.isEmpty()){
                    return false;
                }
                Character p = stack.peek();
                if (p != '{') {
                    return false;
                }
                stack.pop();
            }

            if (x[i] == ')') {
                if (stack.isEmpty()){
                    return false;
                }
                Character p = stack.peek();
                if (p != '(') {
                    return false;
                }
                stack.pop();
            }
            if (x[i] == ']') {
                if (stack.isEmpty()){
                    return false;
                }
                Character p = stack.peek();
                if (p != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }


    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //遍历所有的元素
        for (char c : chars) {
            //如果是左括号，就把他们对应的右括号压栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }
        }
        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.isEmpty();
    }

}
