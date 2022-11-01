package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean isClean = true;

        while (true) {
            isClean = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length(); i++) {
                if (i + 1 < answer.length() && answer.charAt(i) == answer.charAt(i + 1)) {
                    isClean = false;
                    i++;
                } else {
                    sb.append(answer.charAt(i));
                }
            }
            answer = sb.toString();
            if (isClean) {
                break;
            }
        }

        return answer;
    }
}
