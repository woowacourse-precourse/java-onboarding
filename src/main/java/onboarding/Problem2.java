package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";
        return answer;
    }

    private static boolean isConsecutiveDuplicateCharacter(String str, int i) {
        return str.charAt(i) == str.charAt(i-1);
    }
}
