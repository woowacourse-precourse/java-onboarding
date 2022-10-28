package onboarding;

public class Problem4 {
    public static String solution(String word) {
    }

    private static char convertAlpha(char alphabet) {
        if (Character.isLowerCase(alphabet))
            return convertLowerCase(alphabet);

        if (Character.isUpperCase(alphabet))
            return convertUpperCase(alphabet);

        return alphabet;
    }

    private static char convertLowerCase(char lowerCase) {
        int asciiOfa = 'a';
        int asciiOfz = 'z';
        int asciiOfLowerCase = lowerCase;

        char covertedAlphabet = (char) (asciiOfz - (asciiOfLowerCase - asciiOfa));
        return covertedAlphabet;
    }
}
