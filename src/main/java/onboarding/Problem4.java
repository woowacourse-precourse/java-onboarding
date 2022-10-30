package onboarding;

public class Problem4 {
    static int ascii_A = 65;
    static int ascii_Z = 90;
    static int ascii_a = 97;
    static int ascii_z = 122;

    public static String solution(String word) {
        String answer = "";
        StringBuilder tempAnswer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char convertedChar = conversionAlpha(word.charAt(i));
            tempAnswer.append(convertedChar);
        }
        answer = tempAnswer.toString();
        return answer;
    }

    private static char conversionAlpha (int alpha) {
        char resultalpha = (char) alpha;
        if (alpha >= ascii_A && alpha <= ascii_Z) {
            resultalpha = (char) (ascii_A + ascii_Z - alpha);
        }
        if (alpha >= ascii_a && alpha <= ascii_z) {
            resultalpha = (char) (ascii_a + ascii_z - alpha);
        }
        return resultalpha;
    }
}
