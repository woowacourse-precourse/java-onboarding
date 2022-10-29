package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return answer;
    }

    private static String decrypt(String cryptogram) {
        List<Character> charList = new LinkedList<>();

        splitString(cryptogram, charList);
        removeDuplicateChar(charList);
        return combineChar(charList);

    }

    private static String combineChar(List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : charList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private static List<Character> removeDuplicateChar(List<Character> charList) {
        for (int i = 1; i < charList.size(); i++) {
            if (isDuplicate(charList, i)) {
                charList.remove(i - 1);
                charList.remove(i - 1);
                i = 0;
            }
        }
        return charList;
    }

    private static boolean isDuplicate(List<Character> charList, int i) {
        return Objects.equals(charList.get(i - 1), charList.get(i));
    }

    private static List<Character> splitString(String cryptogram, List<Character> charList) {
        char[] chars = cryptogram.toCharArray();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }
}
