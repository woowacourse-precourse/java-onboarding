package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        StringBuilder sb = new StringBuilder(cryptogram);

        boolean isDuplicated = false;

        while (!isDuplicated) {

            isDuplicated = true;

            for (int i = 0; i < sb.length() - 1; i++) {
                char currChar = sb.charAt(i);

                if (currChar == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    isDuplicated = false;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
