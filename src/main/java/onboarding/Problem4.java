package onboarding;

public class Problem4 {
    public static final int upperSum = 155;
    public static final int lowerSum = 219;

    public static String translator(String word) {
        String output = "";
        int wordLen = word.length();
        char curChar;
        char changedChar;
        for (int i = 0; i < wordLen; i++) {
            curChar = word.charAt(i);
            if ((int) curChar >= 65 && (int) curChar <= 90) {
                changedChar = (char) (upperSum - (int) curChar);
            } else if ((int) curChar >= 97 && (int) curChar <= 122) {
                changedChar = (char) (lowerSum - (int) curChar);
            } else {
                changedChar = curChar;
            }
            output += changedChar;
        }
        return output;
    }
    public static String solution(String word) {
        int lenCheck = word.length();
        if (lenCheck < 1 || lenCheck > 1000) {
            return "Wrong Input";
        }
        return translator(word);
    }
}