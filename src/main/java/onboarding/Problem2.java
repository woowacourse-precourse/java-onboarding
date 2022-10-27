package onboarding;
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        for (int i=1;i<sb.length();i++) {
            if (sb.charAt(i-1) == sb.charAt(i)) {
                sb.delete(i-1, i + 1);
                i -= 2;
            }
            if (i<0) {
                i = 0;
            }
        }
        return sb.toString();
    }
}
