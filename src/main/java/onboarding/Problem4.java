package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char a : word.toCharArray()) {
            if (a == ' ') {
                answer += ' ';
            } else {
                if (Character.isUpperCase(a)) {
                    answer += (char) (155 - (int) a);
                } else {
                    answer += (char) (219 - (int) a);
                }
            }
        }
        return answer;
    }
}
