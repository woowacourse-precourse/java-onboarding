package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getDecryption(cryptogram);
    }

    public static String getDecryption(String cryptogram) {
        Stack<Character> characters = deduplication(cryptogram);
        String result = toString(characters);

        if (isComplete(cryptogram, result)) {
            return result;
        }

        return getDecryption(result);
    }

    private static Stack<Character> deduplication(String cryptogram) {
        Stack<Character> characters = new Stack<>();
        char[] chars = cryptogram.toCharArray();

        char before = chars[0];
        characters.push(before);

        for (int i = 1; i < cryptogram.length(); i++) {
            char now = chars[i];
            makeCharacters(characters, before, now);
            before = now;
        }

        return characters;
    }

    private static void makeCharacters(Stack<Character> characters, char before, char now) {
        if (before == now) {
            characters.pop();
            return;
        }

        characters.push(now);
    }

    private static String toString(Stack<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Character character : characters) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    private static boolean isComplete(String cryptogram, String result) {
        return cryptogram.equals(result) || result.length() == 0;
    }
}
