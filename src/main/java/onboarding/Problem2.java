package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deduplicate(cryptogram);
        return answer;
    }

    public static String deduplicate(String cryptogram) {
        StringBuilder cryptogramSB = new StringBuilder(cryptogram);
        int i = 0;
        while (true) {
            if (cryptogramSB.length() == 1) {
                break;
            }
            if (cryptogramSB.length() - 2 == i) {
                if (cryptogramSB.charAt(i) == cryptogramSB.charAt(i + 1)) {
                    cryptogramSB.delete(i, i + 2);
                }
                break;
            }
            if (cryptogramSB.charAt(i) == cryptogramSB.charAt(i + 1)) {
                cryptogramSB.delete(i, i + 2);
                i = -1;
            }
            i++;
        }
        return cryptogramSB.toString();
    }
}
