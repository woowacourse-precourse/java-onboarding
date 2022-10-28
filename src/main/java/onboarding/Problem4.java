package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String[] stringArray = word.split(" ");

        if (throwBoundaryException(word)) {
            return "failed with boundary exception";
        }

        return ;
    }

    public static boolean throwBoundaryException(String word) {

        if (word.length() < 1 || word.length() > 1000) {
            return true;
        }
        return false;
    }
}
