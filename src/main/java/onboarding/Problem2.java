package onboarding;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    static class Cal{
        static String next(String str){
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++){
                if (stack.size() == 0){
                    stack.push(str.charAt(i));
                } else {
                    if (stack.peek().equals(str.charAt(i))){
                        stack.pop();
                    }
                    else{
                        stack.push(str.charAt(i));
                    }
                }
            }
            ArrayList<Character> answer = new ArrayList<>(stack);
            return answer.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }
    public static String solution(String cryptogram) {
        return Cal.next(cryptogram);
    }
}
