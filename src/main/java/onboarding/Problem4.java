package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        List<String> wordList = stringToWordList(word);
        List<String> resultList = new ArrayList<String>();

        // 글자를 변환하고 resultList에 넣는다.
        for (String e : wordList) {
            resultList.add(convertLetter(e));
        }

        // 리스트를 문자열로 연결한다.
        return String.join("", resultList);
    }

    /**
     * 문자열을 문자 리스트로 나눠 담는다.
     * @param word 주어진 단어
     * @return 문자 리스트
     */
    private static List<String> stringToWordList(String word) {
        String[] items = word.split ("");
        return new ArrayList<>(Arrays.asList(items));
    }

    /**
     * 알파벳 외의 문자는 변환하지 않는다.
     * @param letter 글자
     * @return 참 거짓
     */
    private static Boolean isAlphabet(String letter) {
        if(Pattern.matches("^[a-zA-Z]*$", letter)) {
            return true;
        }
        return false;
    }

    /**
     * 알파벳 외의 문자가 아니라면 청개구리 사전을 이용해 문자를 변환한다.
     * @param letter 글자
     * @return 변환된 글자
     */
    private static String convertLetter(String letter) {
        String result = letter;
        if (isAlphabet(letter)) {
            result = frogsDictionary.get(letter);
        }
        return result;
    }

    /**
     * 청개구리 사전을 Map에 담았다.
     */
    private static Map<String, String> frogsDictionary = Map.ofEntries(
            Map.entry("A", "Z"),
            Map.entry("B", "Y"),
            Map.entry("C", "X"),
            Map.entry("D", "W"),
            Map.entry("E", "V"),
            Map.entry("F", "U"),
            Map.entry("G", "T"),
            Map.entry("H", "S"),
            Map.entry("I", "R"),
            Map.entry("J", "Q"),
            Map.entry("K", "P"),
            Map.entry("L", "O"),
            Map.entry("M", "N"),
            Map.entry("N", "M"),
            Map.entry("O", "L"),
            Map.entry("P", "K"),
            Map.entry("Q", "J"),
            Map.entry("R", "I"),
            Map.entry("S", "H"),
            Map.entry("T", "G"),
            Map.entry("U", "F"),
            Map.entry("V", "E"),
            Map.entry("W", "D"),
            Map.entry("X", "C"),
            Map.entry("Y", "B"),
            Map.entry("Z", "A"),
            Map.entry("a", "z"),
            Map.entry("b", "y"),
            Map.entry("c", "x"),
            Map.entry("d", "w"),
            Map.entry("e", "v"),
            Map.entry("f", "u"),
            Map.entry("g", "t"),
            Map.entry("h", "s"),
            Map.entry("i", "r"),
            Map.entry("j", "q"),
            Map.entry("k", "p"),
            Map.entry("l", "o"),
            Map.entry("m", "n"),
            Map.entry("n", "m"),
            Map.entry("o", "l"),
            Map.entry("p", "k"),
            Map.entry("q", "j"),
            Map.entry("r", "i"),
            Map.entry("s", "h"),
            Map.entry("t", "g"),
            Map.entry("u", "f"),
            Map.entry("v", "e"),
            Map.entry("w", "d"),
            Map.entry("x", "c"),
            Map.entry("y", "b"),
            Map.entry("z", "a")
    );
}
