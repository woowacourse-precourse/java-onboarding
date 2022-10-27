package onboarding;

public class Problem2 {
    public static int[] findDupliIndex(StringBuilder s) {
        int i, j;

        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                break;
        }

        j = i + 1;
        while (j < s.length() && s.charAt(i) == s.charAt(j))
            j++;

        return new int[] { i, j };
    }
    
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
