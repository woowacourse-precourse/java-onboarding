package onboarding;


import java.util.Stack;

/**
 * 기능 구현 목록
 * 1) 중복을 제거하는 메서드 구현(Stack 이용)
 * 2) 구현된 값을 answer에 추가하는 기능 구현
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        for(char result : DeleteDuplication(cryptogram)){
            answer.append(result);
        }
        return answer.toString();
    }
    public static Stack<Character> DeleteDuplication(String str) {
        Stack <Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(!stack.isEmpty()){
                if(stack.peek()== c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack;
    }
}
