package onboarding.problem4;

public class TreeFrogConverter {

    private char turnToTreeFrogChar(char c) {
        char srtAlpha;
        if (Character.isUpperCase(c)) {
            srtAlpha = 'A';
        } else {
            srtAlpha = 'a';
        }

        int alphaIdx = c - srtAlpha;

        return (char) (srtAlpha + (25 - alphaIdx));
    }

    public String convert(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {

            if (Character.isAlphabetic(c))
                result.append(turnToTreeFrogChar(c));
            else
                result.append(c);
        }

        return result.toString();
    }
}
