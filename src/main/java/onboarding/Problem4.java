package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(convertAlpha(c));
        }
        return sb.toString();
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

    private static char convertUpperCase(char upperCase) {
        int asciiOfA = 'A';
        int asciiOfZ = 'Z';
        int asciiOfUpperCase = upperCase;

        char covertedAlphabet = (char) (asciiOfZ - (asciiOfUpperCase - asciiOfA));
        return covertedAlphabet;
    }
}
