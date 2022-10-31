package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); ++i) {
            int tmp = 0;
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                tmp = 'a' + 'z' - word.charAt(i);
                answer += (char) tmp;

            } else if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                tmp = 'A' + 'Z' - word.charAt(i);
                answer += (char) tmp;

            } else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}
