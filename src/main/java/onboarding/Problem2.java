package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        answer = decode(cryptogram);

        return answer;
    }
    static String decode(String crypt) {
        StringBuilder sb = new StringBuilder(crypt);
        int i = 0;

        while (i < sb.length() - 1) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                i = 0;
                continue;
            }
            i++;
        }
        return sb.toString();
    }
}