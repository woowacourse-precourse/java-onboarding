package onboarding;

import java.util.Stack;

public class Problem2 {
    private String removeDuplicate(final String N){
        Stack<Character> stk = new Stack<Character>();
        Character prevPoped = null;
        for(int i = 0; i < N.length(); ++i){
            if(stk.empty()) {
                if(prevPoped == null || prevPoped != N.charAt(i))
                    stk.push(N.charAt(i));
            } else{
                //String[i]와 stk.top 을 비교해서, 같다면 stk.pop 다르면 stk.push(String[i]) 실행
                if(N.charAt(i) == stk.peek()){
                    prevPoped = stk.pop();
                } else{
                    if(prevPoped == null || prevPoped != N.charAt(i))
                        stk.push(N.charAt(i));
                }
            }
        }
        String ret = "";
        for(int i = 0; i < stk.size(); ++i){
            Character c = stk.get(i);
            ret += c;
        }
        return ret;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        Problem2 p2 = new Problem2();
        answer = p2.removeDuplicate(cryptogram);
        return answer;
    }
}
