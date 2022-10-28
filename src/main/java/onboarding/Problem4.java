package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        return word.chars().map(Problem4::swapAlphabet).mapToObj(Character::toString).collect(Collectors.joining());
    }

    private static int swapAlphabet(int alphabetASCIICode) {
        if (alphabetASCIICode > 96 && alphabetASCIICode < 123) {
            return 219 - alphabetASCIICode;
        }
        if (alphabetASCIICode > 64 && alphabetASCIICode < 91) {
            return 155 - alphabetASCIICode;
        }
        return alphabetASCIICode;
    }
}
