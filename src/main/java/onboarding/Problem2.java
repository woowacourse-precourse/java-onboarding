package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";
        return answer;
    }
    private static StringBuilder removeConsecutiveSameCharacter(StringBuilder sb, int i) {
        return sb.delete(i-1, i+1);
    }
    private static boolean isConsecutiveSameCharacter(String str, int i) {
        return str.charAt(i) == str.charAt(i-1);
    }
}
