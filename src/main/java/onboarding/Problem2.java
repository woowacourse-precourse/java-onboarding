package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deduplicate(cryptogram);
        return answer;
    }

    public static String deduplicate(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        int i = 0;
        while (true) {
            if (sb.length() - 2 == i) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                }
                break;
            }
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                i = -1;
            }
            System.out.println(sb);
            i++;
        }
        return sb.toString();
    }
}
