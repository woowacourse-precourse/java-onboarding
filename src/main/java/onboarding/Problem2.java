package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Problem2 prob = new Problem2();
        answer = prob.chrsave(cryptogram);
        return answer;
    }

    public String chrval(String cryptogram){
        char[] car = cryptogram.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<car.length;i++) {
            char c = car[i];
            char[] chr;
            if (stack.isEmpty()){
                stack.push(c);
            }
            else{
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }
        String stacksave = stack.toString();
        return stacksave;
    }

    public String chrsave(String s){
        String str = new String(chrval(s));
        return str;
    }
}
