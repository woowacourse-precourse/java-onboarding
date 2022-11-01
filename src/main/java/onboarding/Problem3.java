package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    public static int solution(int number) {
        return findClaps(number);
    }

    private static int findClaps(int number) {
        int totalClaps = 0;

        for (int num = 1; num <= number; num++) {
            totalClaps += clapped(String.valueOf(num));
        }
        return totalClaps;
    }

    private static int clapped(String number) {
        if (containsThreeSixNine(number)) {
            return checkMoreThanOne(number);
        }
        return 0;
    }

    private static int checkMoreThanOne(String number) {
        List<Character> characters = convertToList(number);
        int claps = 0;

        for (Character character : characters) {
            if (isThreeSixNine(character)) {
                claps += 1;
            }
        }
        return claps;
    }

    private static List<Character> convertToList(String number) {
        return number.chars().mapToObj(n -> (char) n)
                .collect(Collectors.toList());
    }

    private static boolean isThreeSixNine(Character character) {
        return character == '3' || character == '6' || character == '9';
    }

    private static boolean containsThreeSixNine(String number) {
        return number.contains("3") || number.contains("6") || number.contains("9");
    }
}
