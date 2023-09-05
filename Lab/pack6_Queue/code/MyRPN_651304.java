package code;

import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class MyRPN_651304 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static Double computeRPN(String rpn) {
        MyStackA_651304 stack = new MyStackA_651304();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();

            if(isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            }
            else {
                if(t.equals("+")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a + b;
                    stack.push(result);
                }
                else if(t.equals("-")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a - b;
                    stack.push(result);
                }
                else if(t.equals("*")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a * b;
                    stack.push(result);
                }
                else if(t.equals("/")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = a / b;
                    stack.push(result);
                }
                else {
                    System.out.println("Please input the correct symbol");
                }
            }
        }
        return stack.pop();
    }
}