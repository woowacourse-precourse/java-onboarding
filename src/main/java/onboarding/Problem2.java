package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        char [] chars = cryptogram.toCharArray();
        char [] res = new char[1000];
        Stack<Character> stack = new Stack<>();
        int i;
        char top = 0;

        for(i = 0; i < chars.length; i++) { // 스택에 문자 하나씩 집어 넣고 top 이랑 비교
            if(!stack.isEmpty()) top = stack.peek();

            if(top == chars[i]) { // top 값이 들어올 값과 같으면 스택에서 pop
                stack.pop();
            }else stack.push(chars[i]); // 아니면 스택에 push
        }

        int k = stack.size();
        while(!stack.isEmpty()) { // 스택 뒤집어서 배열에 저장
            res[k--] = stack.pop();
        }

        answer = String.valueOf(res).trim(); // 문자를 문자열로 변환

        return answer;
    }
}
