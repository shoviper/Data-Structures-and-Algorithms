package code;

import java.util.StringTokenizer;

public class MyShuntingYard_651304 {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infixString) {
        MyQueueL_651304 queue = new MyQueueL_651304();
        MyStackL_651304 stack = new MyStackL_651304();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_651304.isNumeric(t))
                queue.enqueue(t);
            else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.top().equals("(")){
                    queue.enqueue(stack.pop());
                }
                stack.pop(); //discard "("
            } else {
                if(!stack.isEmpty()) { // double lovely bug
                    while (!stack.isEmpty() && order(t) <= order(stack.top())) {
                        queue.enqueue(stack.pop());
                    }
                }
                stack.push(t);
            }
            // System.out.println("current q = " + queue.dumpToString());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        resultPostfixString = queue.dumpToString();
        return resultPostfixString; //"happy coding";
    }
}