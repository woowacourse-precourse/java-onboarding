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

    // 중복 문자를 제거하기 위한 함수
    // stack에 매개변수 str의 문자들을 집어넣으며 조건에 맞게 stack을 구성한다.
    static Stack<Character> duplicate_remove(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int stack_len = stack.size();
            // stack에 아무것도 들어있지 않으면 그냥 추가해준다.
            if(stack_len == 0){
                stack.add(str.charAt(i));
            }
            // stack에 문자가 들어있으면 비교해서 stack에서 뺄건지 추가할건지 결정한다.
            else{
                add_or_pop(stack, str.charAt(i));
            }
        }

        return stack;
    }

    // stack의 맨 위와 문자를 비교하여 stack에 뺄건지 추가할건지 결정하는 함수
    static void add_or_pop(Stack<Character> stack, Character c){
        if(stack.elementAt(stack.size()-1).equals(c)){
            stack.pop();
        }
        else{
            stack.add(c);
        }
    }

    // 조건에 맞게 구성된 stack에서 문자를 하나씩 추가해 답을 리턴하는 함수
    static String solve(String str){
        Stack<Character> stack = duplicate_remove(str);

        StringBuilder sb = new StringBuilder();

        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}


