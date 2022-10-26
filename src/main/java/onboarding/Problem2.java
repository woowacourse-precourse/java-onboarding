/**
 * stack을 이용하여 중복 문자를 제거한다.
 * stack에 추가할 문자가 스택 맨 위의 문자와 같으면 pop을 해준다.
 * 최대 길이가 1000이므로 int형을 사용한다.
 */

package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";

        answer = solve(cryptogram);

        return answer;
    }

    static Stack<Character> duplicate_remove(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int stack_len = stack.size();
            if(stack_len == 0){
                stack.add(str.charAt(i));
            }

            else{
                if(stack.elementAt(stack_len-1).equals(str.charAt(i))){
                    stack.pop();
                }
                else{
                    stack.add(str.charAt(i));
                }
            }
        }

        return stack;
    }

    static String solve(String str){
        Stack<Character> stack = duplicate_remove(str);

        StringBuilder sb = new StringBuilder();

        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}


