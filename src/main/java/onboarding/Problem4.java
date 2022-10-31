package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();

    public static String solution(String word) {
        dictionary();
        String[] wordArr = splitWord(word);
        String[][] changeLetter = changeLetter(wordArr);
        String changeWord = changeWord(changeLetter);
        return changeWord;
    }

    /**
     * 청개구리 사전 만들기
     */
    public static void dictionary() {
        for (int i = 97; i <= 122; i++) {
            dictionary.put((char) i, (char) (219 - i));
        }
        for (int i = 65; i <= 90; i++) {
            dictionary.put((char) i, (char) (155 - i));
        }
    }

    /**
     * word를 단어로 나누기
     * @param word
     * @return String[]
     */
    private static String[] splitWord(String word) {
        return word.split(" ");
    }

    /**
     * 단어를 청개구리 사전을 사용하여 이중배열 글자로 반환
     * @param wordArr
     * @return String[][]
     */
    private static String[][] changeLetter(String[] wordArr) {
        String[][] changeLetter = new String[wordArr.length][];
        for (int i = 0; i < wordArr.length; i++) {
            changeLetter[i] = new String[wordArr[i].length()];
            for (int j = 0; j < wordArr[i].length(); j++) {
                char letter = dictionary.get(wordArr[i].charAt(j));
                changeLetter[i][j] = String.valueOf(letter);
            }
        }
        return changeLetter;
    }

}
