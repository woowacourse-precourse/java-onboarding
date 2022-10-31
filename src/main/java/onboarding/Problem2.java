package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder cryptogramSb = new StringBuilder(cryptogram);

        String answer = deleteConsecutiveDuplicateChars(cryptogramSb);

        return answer;
    }

    private static String deleteConsecutiveDuplicateChars(StringBuilder cryptogramSb) {
        int i = 0;
        for (; i + 1 < cryptogramSb.length(); ) {
            if (i < 0)
                i = 0;

            if (i + 1 >= cryptogramSb.length())
                break;

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
