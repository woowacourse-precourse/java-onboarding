package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String decodeString(String cryptogram) {
        return cryptogram.replaceAll("(.)\\1+", "");
    }
}
