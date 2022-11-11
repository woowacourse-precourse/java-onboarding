package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int count = 99;
        try{ check(cryptogram); }
        catch (IllegalArgumentException e){
            return e.toString();
        }
        Stack<Character> stack = new Stack<>();
        answer = eraseDuplicatedElements(cryptogram, stack);
        return answer;
    }

    /**
     * 기능 목록 1번: 인자의 유효성 검사 메서드
     * */
    private static void check(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000)
            throw new IllegalArgumentException("인자의 길이를 확인해주십시오.");
        for (char c : cryptogram.toCharArray()) {
            if(c==' ') throw new IllegalArgumentException("연속된 문자여야 합니다.");
            if (c < 'a' || c > 'z')
                throw new IllegalArgumentException("소문자 알파벳이 아닌 문자가 포함되어있습니다.");
        }
    }

    /**
     * 기능목록 2번 : 중복된 문자를 제거하는 메서드
     * 스택을 사용해 중복된 문자를 제거한다. cryptogram update
     * */
    private static String eraseDuplicatedElements(String cryptogram, Stack<Character> stack) {
        int count = 0;
        for (char c : cryptogram.toCharArray()) {
            if(stack.isEmpty()) stack.push(c);
            else if (stack.peek() == c){  // 중복된 문자열일 경우
                count++;
                stack.pop();
            }else stack.push(c);
        }

        // cryptogram 업데이트
        cryptogram = "";
        if(stack.isEmpty()) return "";
        for (Character c : stack) {
            cryptogram += c;
        }
        return cryptogram;
    }

}
