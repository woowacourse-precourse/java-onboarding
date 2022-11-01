package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (!checkCondition(cryptogram)) {                                 /*중복문자열이 있는 경우 반복*/
            cryptogram = removeRepeated(cryptogram);
        }
        return cryptogram;

    }

    /**
     * 조건에 맞게 중복된 문자열이 있다면 거짓을 리턴
     **/
    private static boolean checkCondition(String str) {
        if (str.length() <= 1) return true;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) return false;
        }
        return true;
    }

    /**
     * 다음 문자열을 만들어 리턴
     */
    private static String nxtCrypto(Stack<String> stk) {
        StringBuilder nxt = new StringBuilder();
        if (stk.size() < 1) return "";
        for (String s : stk) {
            nxt.append(s);
        }
        return nxt.toString();
    }

    /**
     * 중복을 제거하는 메인 기능
     **/
    private static String removeRepeated(String cryptogram) {
        Stack<String> stk = new Stack<>();
        stk.push(String.valueOf(cryptogram.charAt(0)));                     /*초기화*/

        boolean flag = false; /*찌꺼기 확인용 변수*/
        for (int i = 1; i < cryptogram.length(); i++) {
            if (!isEqualsToPrev(cryptogram, stk, i)) {
                if (flag) {                                                  /*찌꺼기가 있다면*/
                    stk.pop();                                              /*제거*/
                    flag = false;
                }
                stk.push(String.valueOf(cryptogram.charAt(i)));
            } else {
                flag = true;
            }
        }
        if (flag) stk.clear();
        return nxtCrypto(stk);                                              /*일순한 문자열을 다음 다시 재전달*/
    }

    /**
     * 이전의 문자열과 현재 인덱스의 문자열이 같으면 참, 다르면 거짓을 반환
     **/
    private static boolean isEqualsToPrev(String cryptogram, Stack<String> stk, int i) {
        return String.valueOf(cryptogram.charAt(i)).equals(stk.peek());
    }
}
