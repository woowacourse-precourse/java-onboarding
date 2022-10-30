package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        String result = cryptogram;

        //중복이 남아있을때
        while(!result.equals(removeDuplicate(result))) {
            result = removeDuplicate(result);
        }
        return result;

    }

    /**
     * 중복 제거 메서드
     */
    private static String removeDuplicate(String cryptogram) {
        //문자열이 비어있는 경우 빈칸 반환
        if(cryptogram.length() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> result = new Stack<>();    //중복제거한 문자열을 반환할 스택
        Stack<Character> checkStack = new Stack<>();    //중복되는 문자를 저장할 더미 스택

        result.push(cryptogram.charAt(0));   //문자열의 첫 글자 삽입

        //두번째 값 부터 중복 체크
        for (int i = 1; i < cryptogram.length(); i++) {
            checkDuplicate(cryptogram, result, checkStack, i);
        }
        
        //중복을 제거한 result 스택이 비어있을때 빈칸 반환
        if(result.isEmpty()) {
            return "";
        }

        //result 스택에서 String 값으로 변환
        for (Character character : result) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    /**
     * 중복이 있으면 result에 추가하지 않고, 중복이 없으면 result에 추가하는 메서드
     */
    private static void checkDuplicate(String cryptogram, Stack<Character> result, Stack<Character> checkStack, int i) {

        if(!checkStack.isEmpty()) {
            checkStackDuplicate(cryptogram, checkStack, i);
        }

        //checkStack이 비어있을때
        //중복되면 result에 add하지 않고 패스
        if(cryptogram.charAt(i) == result.lastElement()) {
            checkStack.push(result.pop());    //checkStack에 중복되는 문자 pop
            return;
        }

        //중복되지 않을 때
        result.push(cryptogram.charAt(i));
    }

    //입력된 문자열의 연속된 중복이 3번 이상 있을때는 checkStack을 비우지 않음
    private static void checkStackDuplicate(String cryptogram, Stack<Character> checkStack, int i) {
        //cryptogram 문자가 또 한번 중복될때
        if(cryptogram.charAt(i) == checkStack.lastElement()) {
            return;
        }
        //checkStack 비우기
        checkStack.pop();
    }


}
