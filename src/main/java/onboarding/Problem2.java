package onboarding;

import java.util.Stack;

/**
 * 기능 목록
 * 1. Stack을 활용하여 암호문의 연속 문자 제거
 * 2. Stack -> String 변환하는 함수
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> password = new Stack<>();

        char[] cryptogramChar = cryptogram.toCharArray();

        for (char letter : cryptogramChar) {

            if (password.isEmpty()) {
                password.add(letter);
                continue;
            }

            char peekLetter = password.peek();

            if (peekLetter == letter) {
                password.pop();
            }

            if(peekLetter != letter){
                password.add(letter);
            }

        }

        return stackToString(password);
    }

    public static String stackToString(Stack<Character> password){
        StringBuilder letters = new StringBuilder();

        for(char letter : password){
            letters.append(letter);
        }

        return letters.toString();
    }
}
