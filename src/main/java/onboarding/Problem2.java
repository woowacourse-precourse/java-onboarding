package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String tmp_answer = cryptogram;
        boolean flag = true;

        while (flag) {
            flag = false;
            char[] ca = tmp_answer.toCharArray();
            char overlapChar = ' ';
            for(int i = 0; i < ca.length; i++) {
                if(ca[i] == overlapChar) {
                    ca[i] = ' ';
                    ca[i - 1] = ' ';
                    flag = true;
                }
                else
                    overlapChar = ca[i];
            }
            tmp_answer = String.valueOf(ca).replace(" ", "");
        }
        answer = tmp_answer;

        return answer;
    }
}
