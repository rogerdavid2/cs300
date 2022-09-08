import java.util.*;
public class Tester {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the infix expression to process ");
        String input = console.next();
        input = PostfixToInfix.inToPost(input);
        System.out.println("The postfix expression for the input infix is: " + input);
        System.out.println("The final result after evaluating the postfix is: " + PostfixToInfix.evalPost(input));
    }
}
