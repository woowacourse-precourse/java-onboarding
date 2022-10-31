package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer sb = new StringBuffer(cryptogram);
        int i=0;
        for(i=0;i<sb.length()-1;i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                i = -1;
            }
        }
        return sb.toString();
    }
}
