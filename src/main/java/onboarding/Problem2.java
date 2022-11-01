package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack1 = new Stack<Character>();
        for(int i=cryptogram.length()-1; i>=0; i--){
            try{
                if(stack1.peek() == cryptogram.charAt(i)){
                    stack1.pop();
                }else{
                    stack1.push(cryptogram.charAt(i));
                }
            }catch(Exception e){
                stack1.push(cryptogram.charAt(i));
            }

        }
        StringBuilder strb = new StringBuilder();
        while (!stack1.empty()) {
            answer += stack1.pop();
        }
        return answer;
    }
}
