package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static final String ORIGINAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String solution(String word) {
        Map<Character, Character> reverseTable = createReversTable(ORIGINAL);
        String answer = mappingWord(word, reverseTable);

        return answer;
    }
    private static String mappingWord(String word, Map<Character, Character> reverseTable) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if (isNotAlphabetic(ch)) { // 알파벳이 아니라면, 그냥 반환
                stringBuilder.append(ch);
            }
            else { // 알파벳이라면 이제 매핑을 해야함
                checkCase(stringBuilder, ch, reverseTable);
            }
        }

        return stringBuilder.toString();
    }

    private static void checkCase(StringBuilder sb, char ch, Map<Character, Character> reverseTable) {
        if (isUpperCase(ch)) {
            sb.append(reverseTable.get(ch));
        }
        else {
            char upper_ch = Character.toUpperCase(ch);
            sb.append(Character.toLowerCase(reverseTable.get(upper_ch)));
        }
    }

    private static Map<Character, Character> createReversTable(String original) { //ORIGINAL table을 통해 역순으로 map에 매핑
        Map<Character, Character> reverseTable = new HashMap<>();

        StringBuilder sb = new StringBuilder(original);
        String reverseString = sb.reverse().toString();
        for (int i = 0; i < original.length(); i++) {
            reverseTable.put(original.charAt(i), reverseString.charAt(i));
        }

        return reverseTable;
    }

    private static boolean isUpperCase(char character) {
        if (Character.isUpperCase(character)) {
            return true;
        }
        return false;
    }
    private static boolean isNotAlphabetic(char character) {
        return !Character.isAlphabetic(character);
    }
}
