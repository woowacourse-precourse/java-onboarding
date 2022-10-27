package onboarding;

public class Problem4 {

    public static String solution(String word) {
         String answer = "";

        for (int i = 0; i < word.length(); i++) {

            if (isSpelling(word.charAt(i))) {

            } else {

            }

        }

        return answer;
    }

    private static boolean isSpelling(char spelling) {

        if (isUpperCase(spelling)) {
            return true;
        } else if (isLowerCase(spelling)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isUpperCase(char spelling) {

        if (spelling - 'A' >= 0 && spelling - 'A' < 26) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isLowerCase(char spelling) {

        if (spelling - 'a' >= 0 && spelling - 'a' < 26) {
            return true;
        } else {
            return false;
        }

    }

}
