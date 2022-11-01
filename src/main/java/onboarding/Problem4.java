package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return word;
        }
        int[] changeResult = word.chars()
                .map(le -> checkAlpha((char) le) ? changeCharacter((char) le) : le)
                .toArray();

        return new String(changeResult,0,changeResult.length);
    }

    public static boolean checkAlpha(char letter) {
        return Character.isAlphabetic(letter) ;
    }

    public static int changeCharacter(char letter) {
        if (Character.isUpperCase(letter)) {
            return 25 - letter + 'A' * 2;
        }
        return 25 - letter + 'a' * 2;
    }
}
