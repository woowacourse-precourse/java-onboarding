package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
//        String answer = looper(cryptogram);
        String answer = "answer";
        return answer;
    }
    public static String looper(String value) {
        int org = 0;
        int comp = 1;
        String result = value;

        while (org != comp) {
            org = result.length();
            result = dupRemover(result);
            comp = result.length();
        }
        return result;
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
