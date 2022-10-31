package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer buffer = new StringBuffer(cryptogram);
        boolean flag = true;
        while(flag) {
            flag = false;
            int i = 0;
            while (i < buffer.length() - 1) {
                if (buffer.charAt(i) == buffer.charAt(i + 1)) {
                    buffer.delete(i, i + 2);
                    flag = true;
                }
                i++;
            }
        }
        answer = buffer.toString();
        return answer;
    }
}
