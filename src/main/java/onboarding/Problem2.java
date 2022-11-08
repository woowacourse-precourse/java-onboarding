package onboarding;

public class Problem2 {

    public static StringBuffer remover(String answer) {
        StringBuffer sb = new StringBuffer(answer);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb = sb.deleteCharAt(i);
                sb = sb.deleteCharAt(i);
                sb = remover(String.valueOf(sb));
            }
        }
        return sb;
    }

    public static String solution(String cryptogram) {
        return String.valueOf(remover(cryptogram));
    }
}
