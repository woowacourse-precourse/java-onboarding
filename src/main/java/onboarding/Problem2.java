package onboarding;

import java.util.Stack;

public class Problem2 {
    private String removeDuplicate(final String N){
        Stack<Character> stk = new Stack<Character>();
        Character prevPopedChar = null;
        for(int i = 0; i < N.length(); ++i){
            if(stk.empty()) {
                if(prevPopedChar == null || prevPopedChar != N.charAt(i))
                    stk.push(N.charAt(i));
            } else{
                if(N.charAt(i) == stk.peek()){
                    prevPopedChar = stk.pop();
                } else{
                    if(prevPopedChar == null || prevPopedChar != N.charAt(i))
                        stk.push(N.charAt(i));
                }
            }
        }
        //스택에 남아있는 문자열이 정답이다.
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
