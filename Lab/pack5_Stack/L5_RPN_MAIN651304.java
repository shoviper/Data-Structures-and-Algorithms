import code.MyStackA651304;

import java.util.StringTokenizer;

import code.MyRPN651304;

class L5_RPN_Main {
    public static void testTokenizer(String toBeRPN) {
        StringTokenizer st = new StringTokenizer(toBeRPN);
        int i = 0;
        String t = "";
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            if (MyRPN651304.isNumeric(t))
                System.out.println("Token " + i++ + " = " + t);
            else
                System.out.println("Token " + i++ + " = " + t + " is an opearator");
        }
    }
    public static void main(String[] args) { 
        // 3 1 - 4 5 + * -> ans = 18
        //8 5 - 4 2 + 3 / * -> ans = 6
        //2 5 * 4 + 3 2 * 1 + / -> ans = 2
        // String postfixString = "2 5 * 4 + 3 2 * 1 + /";
        // String postfixString = "8 5 - 4 2 + 3 / *";
        String postfixString = "3 1 - 4 5 + *";
        if (args.length > 0)
            postfixString = args[0];
        //testTokenizer(postfixString);
        System.out.println(postfixString);
        System.out.println("Result = " + MyRPN651304.computeRPN(postfixString));
    }
}
