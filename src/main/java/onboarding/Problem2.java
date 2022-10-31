package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        //Stack으로 구현
        Stack<Character> stack = new Stack<>();

        //시작문자는 먼저 넣기
        stack.add(cryptogram.charAt(0));
        //입력된 문자열을 하나씩 돌리기
        for(int i=1; i<cryptogram.length(); i++){
            //스텍의 최상위 문자와 입력된 문자가 같을 시 pop
            if(stack.peek() == cryptogram.charAt(i)){
                stack.pop();
            }
            //그렇지 않을 경우 add
            else{
                stack.add(cryptogram.charAt(i));
            }
        }

        //stack을 문자열로 바꿈
        String answer = "";
        for (Character ch : stack) {
            answer += ch;
        }

        return answer;
    }
}
