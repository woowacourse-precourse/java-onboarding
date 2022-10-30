package onboarding;
import onboarding.exceptions.*;
public class Problem4 {
    static final int upperSum = 155;
    static final int lowerSum = 219;

    static void lengthExceptionCheck(String strIn) throws LengthException {
        if (strIn.length() < 1 || strIn.length() >= 1000) {
            throw new LengthException();
        }
    }

    static String translator(String word) {
        StringBuilder output = new StringBuilder();
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
            output.append(changedChar);
        }
        return output.toString();
    }
    public static String solution(String word) {
        try {
            lengthExceptionCheck(word);
            return translator(word);
        } catch (LengthException e) {
            System.err.println("check the length of given word: " + word);
            return "";
        }
    }
}