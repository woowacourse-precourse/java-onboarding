package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static final int MAX_LENGTH = 1000;
    private static final HashMap<Character, Character> dictionary = new HashMap<>();

    public static String solution(String word) {

        validateLength(word);

        initialDictionary(dictionary);

        return getAnswer(word);
    }

    private static String getAnswer(String word) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (dictionary.containsKey(c)) {
                c = dictionary.get(c);
            }

            sb.append(c);
        }

        return sb.toString();
    }

    private static void initialDictionary(Map<Character, Character> dictionary) {
        dictionary.put('A', 'Z'); dictionary.put('B', 'Y'); dictionary.put('C', 'X'); dictionary.put('D', 'W');
        dictionary.put('E', 'V'); dictionary.put('F', 'U'); dictionary.put('G', 'T'); dictionary.put('H', 'S');
        dictionary.put('I', 'R'); dictionary.put('J', 'Q'); dictionary.put('K', 'P'); dictionary.put('L', 'O');
        dictionary.put('M', 'N'); dictionary.put('N', 'M'); dictionary.put('O', 'L'); dictionary.put('P', 'K');
        dictionary.put('Q', 'J'); dictionary.put('R', 'I'); dictionary.put('S', 'H'); dictionary.put('T', 'G');
        dictionary.put('U', 'F'); dictionary.put('V', 'E'); dictionary.put('W', 'D'); dictionary.put('X', 'C');
        dictionary.put('Y', 'B'); dictionary.put('Z', 'A');

        dictionary.put('a', 'z'); dictionary.put('b', 'y'); dictionary.put('c', 'x'); dictionary.put('d', 'w');
        dictionary.put('e', 'v'); dictionary.put('f', 'u'); dictionary.put('g', 't'); dictionary.put('h', 's');
        dictionary.put('i', 'r'); dictionary.put('j', 'q'); dictionary.put('k', 'p'); dictionary.put('l', 'o');
        dictionary.put('m', 'n'); dictionary.put('n', 'm'); dictionary.put('o', 'l'); dictionary.put('p', 'k'); dictionary.put('q', 'j');
        dictionary.put('r', 'i'); dictionary.put('s', 'h'); dictionary.put('t', 'g'); dictionary.put('u', 'f');
        dictionary.put('v', 'e'); dictionary.put('w', 'd'); dictionary.put('x', 'c'); dictionary.put('y', 'b');
        dictionary.put('z', 'a');
    }

    private static void validateLength(String word) {

        if (word.length() == 0) {
            throw new IllegalArgumentException("word가 비었습니다.");
        }

        if (word.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("word의 길이가 1000을 초과했습니다!");
        }

    }
}
