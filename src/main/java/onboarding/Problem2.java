package onboarding;

import java.util.Stack;
/*
- 기능 구현사항 목록 -
1. 문자열을 배열화한다.
2. stack 생성후 첫번째 문자 넣어두기
3. 남은 배열을 돌면서 이번 문자가
   1) stack 마지막 원소와 같다면 pop
   2) 같지 않다면 add
4. stack 에 남아있는 문자들을 문자열로 만들어서 Return
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] s = cryptogram.toCharArray();
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(s[0]));

        int l = s.length;
        for(int i = 1; i < l; i++){
            if(String.valueOf(stack.peek()).equals(String.valueOf(s[i]))) {
                stack.pop();
            }
            else {
                stack.add(String.valueOf(s[i]));
            }
        }
        while(stack.size() != 0) {
            answer = answer + stack.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        return reverse;
    }
    /*
    지금까지 파이썬만 사용해 와서 자바의 문법이 어색하다.
    이번 프리코스를 통해서 자바의 문법을 능수능란하게 다루는 것을 목표로 한다.
     */
}
