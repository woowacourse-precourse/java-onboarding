package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') answer += " ";
            else {
                Integer num = (int) word.charAt(i);
                if (num < 96) {
                    answer += (char) (77 + (77 - num + 1));
                } else {
                    answer += (char) (109 + (109 - num + 1));
                }
            }
        }
        return answer;
    }
}
