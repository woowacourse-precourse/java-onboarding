package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeConsecutiveDuplicates(cryptogram);
        return answer;
    }

    private static String removeConsecutiveDuplicates(String cryptogram) {
        return cryptogram.replaceAll("([a-z])\\1+", "");
    }
}
