package onboarding;

public class Problem4 {

    public static final int LAST_CHARACTER_ASCII = 25;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            answer.append(getDictionaryCharacter(word.charAt(i)));
        }

        return answer.toString();
    }

    public static char getDictionaryCharacter(char original) {
        if (original == ' ') return original;
        int base = getBaseCharacterASCII(original);
        return (char) (LAST_CHARACTER_ASCII - (original - base) + base);
    }

    public static int getBaseCharacterASCII(char c) {
        int base = 'a';
        if (isUpper(c)) base = 'A';
        return base;
    }

    public static boolean isUpper(char a) {
        return a >= 'A' && a <= 'Z';
    }

}
