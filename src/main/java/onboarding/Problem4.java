package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverse(word);
    }

    public static String reverse(String word) {
        StringBuilder reverseString = new StringBuilder();

        for (char curChar : word.toCharArray()) {
            if (curChar >= 65 && curChar <= 90) {
                reverseString.append((char)(155 - curChar));
            }
            if (curChar >= 97 && curChar <= 122) {
                reverseString.append((char)(219 - curChar));
            }
            if (curChar == ' ') reverseString.append(' ');
        }
        return reverseString.toString();
    }
}
