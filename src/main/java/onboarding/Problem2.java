package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer answer = new StringBuffer(cryptogram);
        int index = 0;
        while (index < answer.length() - 1) {
            if (answer.charAt(index) == answer.charAt(index + 1)) {
                answer.deleteCharAt(index + 1);
                answer.deleteCharAt(index);
                index--;
            } else {
                index++;
            }
        }
        return answer.toString();
    }
}
