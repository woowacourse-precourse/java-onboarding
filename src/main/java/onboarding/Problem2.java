package onboarding;
// 1. Deque을 이용하여 기능 구현
// 2. Deque이 비어있을 경우 offer
// 3. 새로운 문자와 Deque의 마지막 문자가 같을경우 poll
// 4. 다를 경우 offer
// 5. 최종적으로 남아있는 문자 반환
import java.util.*;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i<cryptogram.length();i++){
            char c = cryptogram.charAt(i);

            if(dq.isEmpty()){
                dq.offerLast(c);
            }
            else{
                if(dq.peekLast() == c){
                    dq.pollLast();
                }
                else{
                    dq.offerLast(c);
                }
            }
        }
        return answer;
    }
}
