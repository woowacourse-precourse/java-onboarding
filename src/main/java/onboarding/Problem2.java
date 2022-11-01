package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] str = cryptogram.toCharArray();
        char[] pattern = new char[cryptogram.length() + 1];
        int index = 1;
        for (char c : str) {
            if (pattern[index - 1] == c) {
                pattern[index - 1] = '\u0000';
                index--;
            } else {
                pattern[index] = c;
                index++;
            }
        }
        return String.valueOf(pattern).trim();
    }
}
