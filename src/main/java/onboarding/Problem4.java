package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();

    public static String solution(String word) {
        dictionary();
        String[][] word2Arr = splitWord(word);
        return "";
    }

    /**
     * 청개구리 사전 만들기
     */
    public static void dictionary() {
        for (int i = 97; i <= 122; i++) {
            dictionary.put((char)i, (char)(219-i));
        }
    }

    /**
     * word를 한 글자씩 나누기
     * @param word
     * @return String[][]
     */
    private static String[][] splitWord(String word) {
        String[] wordArr = word.split(" ");
        String[][] word2Arr = new String[wordArr.length][];
        for (int i = 0; i < wordArr.length; i++) {
            word2Arr[i] = wordArr[i].split("");
        }
        return word2Arr;
    }

}
