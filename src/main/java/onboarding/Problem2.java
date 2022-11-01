package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> charList = convertStringToCharList(cryptogram);
        List<Character> decoded = decode(charList);
        return convertCharListToString(decoded);
    }

    public static List<Character> convertStringToCharList(String s) {
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        return charList;
    }

    public static List<Character> decode(List<Character> charList) {
        while (hasConsecutiveChars(charList)) {
            charList = popConsecutiveChars(charList);
        }
        return charList;
    }

    public static boolean hasConsecutiveChars(List<Character> charList) {

        if (charList.size() <= 1) {
            return false;
        }

        for (int i = 1; i < charList.size(); i++) {
            if (charList.get(i).equals(charList.get(i - 1))) {
                return true;
            }
        }

        return false;
    }

    public static List<Character> popConsecutiveChars(List<Character> charList) {
        List<Character> newCharList = new ArrayList<>();

        Character previous = null;
        int count = 0;

        for (Character current : charList) {
            if (Objects.equals(previous, current)) {
                count += 1;
                continue;
            }

            if (count == 1) {
                newCharList.add(previous);
            }

            previous = current;
            count = 1;
        }

        if (count == 1) {
            newCharList.add(previous);
        }

        return newCharList;
    }

    public static String convertCharListToString(List<Character> charList) {
        StringBuilder builder = new StringBuilder(charList.size());
        for (Character ch : charList) {
            builder.append(ch);
        }
        return builder.toString();
    }

}
