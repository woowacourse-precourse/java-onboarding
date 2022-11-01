package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = getTrimedString(cryptogram);
        return answer;
    }

    private static String getTrimedString(String cryptogram) {
        String answer = "";
        for (char ch : cryptogram.toCharArray()) {
            if (answer.endsWith(String.valueOf(ch))) {
                answer = answer.substring(0, answer.length()-1);
            } else {
                answer += ch;
            }
        }
        return answer;
    }
}
