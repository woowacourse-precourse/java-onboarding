package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static final String ORIGINAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }

    public static String solution(String word) {
        mapping(ORIGINAL);
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if (isNotAlphabetic(ch)) { // 알파벳이 아니라면, 그냥 반환
                sb.append(ch);
            }
            else { // 알파벳이라면 이제 매핑을 해야함
                checkCase(sb, ch);
            }
        }

        return sb.toString();
    }

    private static void checkCase(StringBuilder sb, char ch) {
        if (isUpperCase(ch)) {
            sb.append(map.get(ch));
        }
        else {
            char upper_ch = Character.toUpperCase(ch);
            sb.append(Character.toLowerCase(map.get(upper_ch)));
        }
    }

    private static void mapping(String original) { //ORIGINAL table을 통해 역순으로 map에 매핑
        StringBuilder sb = new StringBuilder(original);
        String reverseTable = sb.reverse().toString();
        for (int i = 0; i < original.length(); i++) {
            map.put(original.charAt(i), reverseTable.charAt(i));
        }
    }

    private static boolean isUpperCase(char character) {
        if (Character.isUpperCase(character)) {
            return true;
        }
        return false;
    }
    private static boolean isNotAlphabetic(char character) {
        if (Character.isAlphabetic(character)) {
            return false;
        }
        return true;
    }
}
