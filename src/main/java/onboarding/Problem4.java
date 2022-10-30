package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        // 예외 사항 체크
        if (checkInvalid(word)) {
            return "제한사항 위반입니다.";
        }

        // 소문자, 대문자 알파벳 표기
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] lower = lowerCase.toCharArray();
        char[] lowerReverse = reverseString(lowerCase).toCharArray();

        char[] upper = upperCase.toCharArray();
        char[] upperReverse = reverseString(upperCase).toCharArray();

        // HashMap 으로 청개구리 사전 작성
        HashMap<Character, Character> lowerDict = new HashMap<Character, Character>();
        HashMap<Character, Character> upperDict = new HashMap<Character, Character>();
        for (int i = 0; i < lower.length; i++) {
            lowerDict.put(lower[i], lowerReverse[i]);
        }
        for (int i = 0; i < upper.length; i++) {
            upperDict.put(upper[i], upperReverse[i]);
        }

        // word 에 따른 결과값 반환
        return convert(word, lowerDict, upperDict);
    }

    // 제한 사항 체크
    private static boolean checkInvalid(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return true;
        }
        return false;
    }

    // 청개구리 사전을 참고한 문자열 반환하는 함수
    private static String convert(String word, HashMap<Character, Character> lowerDict, HashMap<Character, Character> upperDict) {
        char[] chars = word.toCharArray();
        String result = "";

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                result += upperDict.get(ch);
            } else if (Character.isLowerCase((ch))) {
                result += lowerDict.get(ch);
            } else {
                result += ch;
            }
        }
        return result;
    }

    // 반대로 뒤집은 문자열 반환하는 함수
    private static String reverseString(String str) {
        String result = "";
        char[] reverse = str.toCharArray();

        for (int i = reverse.length - 1; i >= 0; i--) {
            result += reverse[i];
        }
        return result;
    }

}
