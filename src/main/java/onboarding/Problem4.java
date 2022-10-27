package onboarding;

public class Problem4 {

    public static String solution(String word) {
         String answer = "";

        return answer;
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
