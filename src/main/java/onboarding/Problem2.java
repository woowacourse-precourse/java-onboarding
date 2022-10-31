package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder cryptogramSb = new StringBuilder(cryptogram);

        String answer = deleteConsecutiveDuplicateChars(cryptogramSb);

        return answer;
    }

    private static String deleteConsecutiveDuplicateChars(StringBuilder cryptogramSb) {
        int i = 0;
        for (; i < cryptogramSb.length() - 1; ) {
            if (cryptogramSb.charAt(i) != cryptogramSb.charAt(i+1)) {
                i++;
            }
            else {
                cryptogramSb.deleteCharAt(i+1);
                cryptogramSb.deleteCharAt(i);
                i--;
            }
        }

        return cryptogramSb.substring(0, i+1);
    }
}
