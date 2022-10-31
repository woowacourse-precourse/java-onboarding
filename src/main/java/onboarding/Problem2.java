package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);
        for (int i = 0; i < sb.length() - 1; ) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if (i > 0) i--;
                continue;
            }
            i++;
        }
        answer = sb.toString();
        return answer;
    }
}