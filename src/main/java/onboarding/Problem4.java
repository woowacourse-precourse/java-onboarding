package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] charArr = word.toCharArray();

        for (char w: charArr) {
            if (w == ' ') {
                answer += " ";
                continue;
            }
            if (w - 'a' < 0) {
                answer += (char)('A' + 'Z' - w);
            } else {
                answer += (char)('a' + 'z' - w);
            }
        }

        return answer;
    }
}
