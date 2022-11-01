package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reversed(word);
    }

    public static String reversed(String word) {

        StringBuilder result = new StringBuilder();
        char[] chars = word.toCharArray();
        int reversedWord, tmp, ascii;

        for (char aChar : chars) {

            if (Character.isUpperCase(aChar)) {
                ascii = 65;
            } else if (Character.isLowerCase(aChar)) {
                ascii = 97;
            } else {
                result.append(' ');
                continue;
            }
            tmp = Math.abs(ascii - aChar);
            reversedWord = (ascii + 25) - tmp;
            result.append((char) reversedWord);
        }

        return result.toString();
    }
}
