package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     * 스택 이용해서 문자 제거하는 함수
     * 스택을 문자열로 반환하는 함수
     */
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /*
     *스택을 문자열로 반환하는 함수
     */
    static String dump(Stack<Character> ptr) {
        String result = "";
        if(ptr.size() <= 0 ){
            return "";
        }else{
            for(int i = 0 ; i < ptr.size() ; i++) {
                result = result+ptr.get(i);
            }
        }
        return result;
    }

    /*
     *스택 이용해서 문자 제거하는 함수
     */
    static String remove(String cryptogram){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < cryptogram.length(); i++){
            char c = cryptogram.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return dump(stack);
    }
}

