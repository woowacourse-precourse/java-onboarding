package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (isAlphabet(letter)) {
                letter = convertLetterToReverse(letter);
            }
            builder.append(letter);
        }
        return builder.toString();
    }

    private static boolean isAlphabet(char letter) {
        return Character.isUpperCase(letter) || Character.isLowerCase(letter);
    }

    private static char convertLetterToReverse(char letter) {
        if (Character.isUpperCase(letter)) {
            return (char) (155 - letter);
        } else {
            return (char) (219 - letter);
        }
    }
}
