package onboarding;

public class Problem4 {
    private static final String UPPERCASE = "uppercase";
    private static final String LOWERCASE = "lowerCase";
    private static final String OTHER_LETTERS = "otherLetters";
    private static final int UPPERCASE_A_ASCIICODE = 65;
    private static final int UPPERCASE_Z_ASCIICODE = 90;
    private static final int LOWERCASE_A_ASCIICODE = 97;
    private static final int LOWERCASE_Z_ASCIICODE = 122;

    public static String solution(String word) {
        String answer;

        int[] asciiCodes = convertStringtoASCIICode(word);
        int[] reverseAsciiCodes = reverseLetter(asciiCodes);

        answer = convertASCIICodetoString(reverseAsciiCodes);

        return answer;
    }

    public static int[] convertStringtoASCIICode(String word) {
        char[] words = word.toCharArray();
        int[] asciiCodes = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            asciiCodes[i] = words[i];
        }

        return asciiCodes;
    }

    public static String classifyASCIIType(int asciiCode) {
        if (65 <= asciiCode && asciiCode <= 90) {
            return UPPERCASE;
        } else if (97 <= asciiCode && asciiCode <= 122) {
            return LOWERCASE;
        }

        return OTHER_LETTERS;
    }

    public static int[] reverseLetter(int[] asciiCodes) {
        int[] reverseAsciiCodes = new int[asciiCodes.length];

        for (int i = 0; i < asciiCodes.length; i++) {
            String letterType = classifyASCIIType(asciiCodes[i]);

            switch (letterType) {
                case UPPERCASE:
                    reverseAsciiCodes[i] = UPPERCASE_Z_ASCIICODE - (asciiCodes[i] - UPPERCASE_A_ASCIICODE);
                    break;
                case LOWERCASE:
                    reverseAsciiCodes[i] = LOWERCASE_Z_ASCIICODE - (asciiCodes[i] - LOWERCASE_A_ASCIICODE);
                    break;
                case OTHER_LETTERS:
                    reverseAsciiCodes[i] = asciiCodes[i];
                    break;
            }
        }

        return reverseAsciiCodes;
    }

    public static String convertASCIICodetoString(int[] reverseAsciiCodes) {
        char[] reverseWords = new char[reverseAsciiCodes.length];
        String result;

        for (int i = 0; i < reverseAsciiCodes.length; i++) {
            reverseWords[i] = (char) reverseAsciiCodes[i];
        }

        result = String.valueOf(reverseWords);

        return result;
    }
}