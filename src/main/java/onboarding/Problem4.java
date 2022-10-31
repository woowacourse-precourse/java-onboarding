package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int gap = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c > 64 && c < 91) {
                gap = 25 - (c - 65) * 2;
            } else if (c > 96 && c < 123) {
                gap = 25 - (c - 97) * 2;
            } else {
                answer += c;
                continue;
            }
            answer += (char) (c + gap);
        }
        return answer;
    }
}
