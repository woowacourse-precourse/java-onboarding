package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder convertStringBuilder = new StringBuilder(cryptogram);
        String answer = "answer";
        int dup = Integer.MAX_VALUE;

        while (dup != 0) {
            int cnt = 0;
            for (int i = 0; i < convertStringBuilder.length() - 1; i++) {
                if (convertStringBuilder.charAt(i) == convertStringBuilder.charAt(i + 1)) {
                    cnt++;
                    convertStringBuilder.deleteCharAt(i + 1);
                    convertStringBuilder.deleteCharAt(i);
                }
            }
            dup = cnt;
        }

        answer = convertStringBuilder.toString();
        return answer;
    }
}
