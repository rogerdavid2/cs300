import java.lang.*;

public class PostfixToInfix {
    public static String inToPost(String s) {
        LinkedStack stack = new LinkedStack();
        String output = "";
        for(int cur = 0; cur < s.length(); cur++) {
            char c = s.charAt(cur);
            if(Character.isLetterOrDigit(c)) {
                output = output + c;
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                char topToken = (char)stack.top();
                while (topToken != '(') {
                    output = output + stack.pop();
                    topToken = (char)stack.top();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence((char)stack.top(), c)) {
                    output = output + stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            output = output + stack.pop();
        }
        return output;
    }

   public static boolean precedence(char stackV, char curV) {
        return stackValues(stackV) > curValues(curV);
    }

   public static Object evalPost(String s) {
       LinkedStack stack = new LinkedStack();
        for(int idx = 0; idx < s.length(); idx++) {
            String s2 = String.valueOf(s.charAt(idx));
            if (s2.equals("1") || s2.equals("2") || s2.equals("3") ||
                    s2.equals("4") || s2.equals("5") || s2.equals("6") || s2.equals("7") || s2.equals("8") || s2.equals("9")) {
                stack.push(s2);
            } else {
                String a = "";
                String b = "";
                if (s2.equals("*")) {
                    Object temp = stack.pop();
                    a += temp;
                    Object temp2 = stack.pop();
                    b += temp2;
                    int answer = Integer.parseInt(b) * Integer.parseInt(a);
                    stack.push(answer);
                } else if (s2.equals("/")) {
                    Object temp = stack.pop();
                    a += temp;
                    Object temp2 = stack.pop();
                    b += temp2;
                    int answer = Integer.parseInt(b) / Integer.parseInt(a);
                    stack.push(answer);
                } else if (s2.equals("+")) {
                    Object temp = stack.pop();
                    a += temp;
                    Object temp2 = stack.pop();
                    b += temp2;
                    int answer = Integer.parseInt(b) + Integer.parseInt(a);
                    stack.push(answer);
                } else if (s2.equals("-")) {
                    Object temp = stack.pop();
                    a += temp;
                    Object temp2 = stack.pop();
                    b += temp2;
                    int answer = Integer.parseInt(b) - Integer.parseInt(a);
                    stack.push(answer);
                } else if (s2.equals("^")) {
                    Object temp = stack.pop();
                    a += temp;
                    Object temp2 = stack.pop();
                    b += temp2;
                    int answer = (int) Math.pow(Double.parseDouble(b), Double.parseDouble(a));
                    stack.push(answer);
                }
            }
        }
       return stack.pop();
   }

    public static int stackValues(char c) {
        if (c == '(') {
            return 0;
        } else if (c == '^') {
            return 5;
        } else if (c == '*' || c == '/' || c == '%') {
            return 4;
        } else if (c == '+' || c == '-') {
            return 2;
        }
        return 0;
    }

    public static int curValues(char c) {
        if(c == '(') {
            return 100;
        } else if(c == ')') {
            return 0;
        } else if(c == '^') {
            return 6;
        } else if(c == '*' || c == '/' || c == '%') {
            return 3;
        } else if(c == '+' || c == '-') {
            return 1;
        }
        return 0;
    }
}