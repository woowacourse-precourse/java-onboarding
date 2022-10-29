package onboarding;

import java.util.HashMap;

/**
 * [o] 알파벳 외의 문자는 변환하지 않는다.
 * [o] word를 청개구리 사전을 참고해 반대로 변환한다.
 * [o] 알파벳 대문자는 대문자로, 알파벳 소문자는 소문자로 변환한다.
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> treeFrogDict = replaceOtherCharDict();
        answer = getReverseWord(word, treeFrogDict);
        answer = checkUpperLower(word, answer);
        return answer;
    }

    public static HashMap replaceOtherCharDict() {
        HashMap<Character, Character> treeFrogDict = new HashMap<>(26);

        for (int i = 65; i <= 90; i++) {
            char originalWord = (char) i;
            char replaceWord = (char) (155 - i);

            treeFrogDict.put(originalWord, replaceWord);
        }

        return treeFrogDict;
    }

    public static String getReverseWord(String word, HashMap<Character,Character> dict) {
        String upperWord = word.toUpperCase();
        String replaceWord = "";

        for(int i = 0; i < upperWord.length(); i++) {
            char target = upperWord.charAt(i);

            if(target == ' ') {
                replaceWord += ' ';
                continue;
            }

            replaceWord += dict.get(target);

        }

        return replaceWord;
    }

    public static String checkUpperLower(String originalWord, String answer) {
        for(int i = 0; i<originalWord.length(); i++) {
            char target = originalWord.charAt(i);

            if (Character.isUpperCase(target)) {
                continue;
            }

            char lowerWord = Character.toLowerCase(answer.charAt(i));
            answer = answer.substring(0, i) + lowerWord + answer.substring(i+ 1);
        }

        return answer;
    }
}
