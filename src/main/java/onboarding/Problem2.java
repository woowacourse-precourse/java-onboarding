package onboarding;
import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for(char c : cryptogram.toCharArray()){
            if(!stack.empty() && stack.peek().equals(c)) stack.pop();
            else stack.add(c);
        }

        Iterator<Character> itr = stack.iterator();
        while(itr.hasNext()){
            String res = itr.next().toString();
            answer += res;
        }

        return answer;
    }
}
