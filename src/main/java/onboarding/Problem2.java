package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        StringBuilder cryptogramSb = new StringBuilder(cryptogram);

        int i = 0;
        for (; i < cryptogramSb.length() - 1; ) {
            if (cryptogramSb.charAt(i) != cryptogramSb.charAt(i+1)) {
                answer = cryptogramSb.substring(0, i+1);
                i++;
            }
            else {
                cryptogramSb.deleteCharAt(i+1);
                cryptogramSb.deleteCharAt(i);
                i--;
            }
        }

        answer = cryptogramSb.substring(0, i+1);

        return answer;
    }
}
