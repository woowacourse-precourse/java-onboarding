package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        int i = 0;
        while(i < sb.length() && sb.length() > 1) {
            if(i == 0) {
                i++;
                continue;
            }
            if(isConsecutiveSameCharacter(sb, i)) {
                removeConsecutiveSameCharacter(sb, i);
                i--;
                continue;
            }
            i++;
        }
        String answer = sb.toString();
        return answer;
    }
    private static StringBuilder removeConsecutiveSameCharacter(StringBuilder sb, int i, int n) {
        return sb.delete(i, i+n);
    }
    private static boolean isConsecutiveSameCharacter(StringBuilder str, int i) {
        return str.charAt(i) == str.charAt(i+1);
    }
}
