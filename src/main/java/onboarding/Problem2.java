package onboarding;
import java.util.Stack;
/*제한 사항
    cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
    cryptogram은 알파벳 소문자로만 이루어져 있다.
기능 목록
 1. Stack에 문자열의 문자를 저장한다. (만일 전에 삽입된 문자가 현재 문자가 같을 경우는 pop)
 2. answer로 리턴할 값인 Stringbuffer에 각 문자를 붙여주고, reverse 함수를 통해 정답에 저장한다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> s = new Stack<>();
        int i;
        int k = 0;
        for(i = 0;i<cryptogram.length(); i++){
            if((!s.empty()) && (s.peek() == cryptogram.charAt(i))){
                s.pop();
            }else{
                s.push(cryptogram.charAt(i));
            }
        }
        StringBuffer ts = new StringBuffer("");
        while(!s.empty()){
            ts.append(s.pop().toString());
        }
        answer = ts.reverse().toString();
        return answer;
    }
}
