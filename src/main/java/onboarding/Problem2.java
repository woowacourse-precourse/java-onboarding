package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String before = cryptogram;
        String after = removeConsecutiveCharacter(before);
        while(!before.equals(after)) {
            before = after;
            after = removeConsecutiveCharacter(before);
        }
        return after;
    }

    private static String removeConsecutiveCharacter(String before) {
        StringBuilder sb = new StringBuilder(before);
        int i = 0;
        while(i < sb.length() && sb.length() > 1) {
            int maxSameLength = maxSameCharacter(sb, i);
            if(maxSameLength == 1) {
                i++;
                continue;
            }
            removeConsecutiveSameCharacter(sb, i, maxSameLength);
        }
        String answer = sb.toString();
        return answer;
    }

    private static int maxSameCharacter(StringBuilder sb, int start) {
        int n = 1;
        for(int i = start; i < sb.length()-1; i++) {
            if(!isConsecutiveSameCharacter(sb, i)) {
                return n;
            }
            n++;
        }
        return n;
    }
    private static StringBuilder removeConsecutiveSameCharacter(StringBuilder sb, int i, int n) {
        return sb.delete(i, i+n);
    }
    private static boolean isConsecutiveSameCharacter(StringBuilder str, int i) {
        return str.charAt(i) == str.charAt(i+1);
    }
}
