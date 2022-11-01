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
            if (charStack.isEmpty()) charStack.add(str);
            else {
                //추출한 str값이 stack 마지막 push값(=peek)과 같으면 제거(=pop)
                if (str.equals(charStack.peek())) charStack.pop();
                else charStack.add(str);
            }
        }
        for (String s : charStack) answer += s;
        return answer;
    }
}
