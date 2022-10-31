package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
    	String answer = "";

        //Stack 이용하기 (삽입, 삭제가 용이)
        Stack<String> charStack = new Stack<>();
        String str = "";
        for(int i=0; i<cryptogram.length(); i++) {
            //각 자리의 글씨 가져오기
            str = cryptogram.charAt(i) + "";
            //맨 처음에는 첫번째 글자 Stack에 넣어주기
        }
        
        return answer;
    }
}
