package onboarding;

public class Problem4 {
    private static char conversionUpperLower(char c) {
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }else if (Character.isLowerCase(c)) {
            c = Character.toUpperCase(c);
        }
        return c;
    }
    private static char conversionAscii(char c) {
        char result = 0;

        return result;
    }
    public static String solution(String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            wordArr[i] = conversionAscii(word.charAt(i));
            wordArr[i] = conversionUpperLower(word.charAt(i));
        }
        word = String.valueOf(wordArr);
        return word;
    }
}
