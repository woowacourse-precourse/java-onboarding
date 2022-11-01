package onboarding;

import java.util.Stack;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String cry = scan.nextLine();

        System.out.println(solution(cry));
    }


    public static String solution(String cryptogram) {
        String result = "";
        Stack<Character> stack = new Stack<Character>();


        for(int i=0; i<cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);

            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        for (int i=0; i<stack.size(); i++) {
            result+= (stack.get(i)).toString();
        }

        return result;
    }
}