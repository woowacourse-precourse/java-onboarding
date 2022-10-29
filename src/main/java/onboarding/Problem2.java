package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }


    public static String dupRemover(String value) {
        String result;
        if (value.length() <= 1) {
            return value;
        }
        if (value.charAt(0) == value.charAt(1)) {
            return dupRemover(value.substring(2));
        } else {
            return value.charAt(0) + dupRemover(value.substring(1));
        }

    }

}
