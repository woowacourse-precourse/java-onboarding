package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            if (target >= 65 && target < 91) {
                answer.append((char) (90 - (target - 65)));
            } else if (target >= 97 && target < 123) {
                answer.append((char) (122 - (target - 97)));
            } else {
                answer.append(target);
            }
        }
        return answer.toString();
    }
}
