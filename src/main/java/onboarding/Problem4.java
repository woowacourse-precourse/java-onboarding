package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] alphArr = new char[26];

        for (int i = 0; i < alphArr.length; i++) {
            alphArr[i] = (char)('a' + i);
        }

        Map<Character, Character> alphabetMap = new HashMap<>(); // 키와 밸류로 넣음

        for (int i = 0; i < alphArr.length; i++) {
            alphabetMap.put(alphArr[i], alphArr[alphArr.length - i - 1]);
        }

        char[] wordArr = stringToCharArr(word);

        for (int i = 0; i < wordArr.length; i++) {
            char temp;
            char valueTemp;
            if(checkCase(wordArr[i]) == 1) {
                temp = Character.toLowerCase(wordArr[i]);
                valueTemp = alphabetMap.get(temp);
                wordArr[i] = Character.toUpperCase(valueTemp);
            } else if (checkCase(wordArr[i]) == -1) {
                valueTemp = alphabetMap.get(wordArr[i]);
                wordArr[i] = valueTemp;
            } else
                continue;
        }

        answer = new String(wordArr);

        return answer;
    }

    public static int checkCase(char word) { // 1 : 대문자 0 : 영어 이외 글자 -1 : 소문자
        if(Character.isUpperCase(word)) {
            return 1;
        } else if (Character.isLowerCase(word))
            return -1;
        else
            return 0;

    }

    // 문장 리스트로 바꾸기
    public static char[] stringToCharArr(String word) {
        char[] list = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            list[i] = word.charAt(i);
        }

        return list;
    }
}
