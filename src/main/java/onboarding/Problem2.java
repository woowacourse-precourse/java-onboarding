package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        StringBuilder cryptogramSb = new StringBuilder(cryptogram);

        int i = 0, j = 1;
        for (; j < cryptogramSb.length(); ) {
            if (cryptogramSb.charAt(i) != cryptogramSb.charAt(j)) {
                answer = cryptogramSb.substring(0, i+1);
                i++;
                j++;
            }
            else {
                cryptogramSb.deleteCharAt(j);
                cryptogramSb.deleteCharAt(i);
                i--;
                j = i + 1;
            }
        }

        answer = cryptogramSb.substring(0, i+1);

        return answer;
    }
}
