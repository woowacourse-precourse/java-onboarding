package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        HashMap<Character, Character> treeFrogDictionary = makeTreeFrogDictionary();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char convertedCharacter = convert(word, i, treeFrogDictionary);

            sb.append(convertedCharacter);
        }

        answer = sb.toString();

        return answer;
    }

    private static HashMap<Character, Character> makeTreeFrogDictionary() {
        int alphabetCount = 26;
        int halfOfTheAlphabetCount = alphabetCount / 2;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < halfOfTheAlphabetCount; i++) {
            map.put((char)('A' + i), (char)('Z' - i));
            map.put((char)('Z' - i), (char)('A' + i));
        }

        return map;
    }

    private static char convert(String word, int idx, HashMap<Character, Character> treeFrogDictionary) {
        char current = word.charAt(idx);
        char convertChar;

        if (current >= 'a' && current <= 'z') {
            convertChar = Character.toUpperCase(current);
            convertChar = treeFrogDictionary.get(convertChar);
            convertChar = Character.toLowerCase(convertChar);

            return convertChar;
        }

        if (!treeFrogDictionary.containsKey(current)) {
            convertChar = current;

            return convertChar;
        }

        convertChar = treeFrogDictionary.get(current);
        return convertChar;
    }
}
