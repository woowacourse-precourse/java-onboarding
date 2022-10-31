package onboarding;

public class Problem4 {
    private static final String UPPERCASE = "uppercase";
    private static final String LOWERCASE = "lowerCase";
    private static final String OTHER_LETTERS = "otherLetters";
    
    public static String solution(String word) {
        String answer = "";
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
}
