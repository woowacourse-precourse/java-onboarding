package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            int ascii = word.toCharArray()[i];

            if (Character.isLowerCase(ascii)) {
                if (ascii + 25 > 122) {
                    ascii = 122 - ((ascii + 25) % 122);
                }
            }

            if (Character.isUpperCase(ascii)) {
                if (ascii + 25 > 90) {
                    ascii = 90 - ((ascii + 25) % 90);
                }
            }
            result.add((char) ascii);
        }

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

    }
}
