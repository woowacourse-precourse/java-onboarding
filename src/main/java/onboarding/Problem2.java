package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

    }

    private static boolean[] checkDuplicatedChar(String cryptogram) {
        boolean[] duplicated = new boolean[cryptogram.length()];

        for (int i = 1; i < cryptogram.length(); i++) {
            char curChar = cryptogram.charAt(i);
            char prevChar = cryptogram.charAt(i - 1);
            if (curChar == prevChar) {
                duplicated[i - 1] = true;
                duplicated[i] = true;
            }
        }
        return duplicated;
    }
}


