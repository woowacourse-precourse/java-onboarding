package onboarding;

public class Problem4 {

    public static char turnToTreeFrogChar(char c) {

        char srtAlpha;
        if (Character.isUpperCase(c)) {
            srtAlpha = 'A';
        } else {
            srtAlpha = 'a';
        }

        int alphaIdx = c - srtAlpha;

        char treeFrogChar = (char)(srtAlpha + (25 - alphaIdx));
        return treeFrogChar;
    }

    public static String solution(String word) {
        String result = "";

        for (char c: word.toCharArray()) {

            if (Character.isAlphabetic(c))
                result += turnToTreeFrogChar(c);
            else
                result += c;
        }

        return result;
    }
}
