package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer sb = new StringBuffer(cryptogram);
        char check = sb.charAt(0);

        for (int i = 1; i < sb.length(); i++) {
            if (check == sb.charAt(i)) {
                sb.delete(i - 1, i + 1);
                if (sb.length() == 0) {
                    break;
                }
                i -= 2;
                check = sb.charAt(i);
            } else {
                check = sb.charAt(i);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
