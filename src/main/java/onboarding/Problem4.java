package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char w : word.toCharArray()) {
            if (w == ' ') {
                answer+=' ';
            } else {
                if (Character.isUpperCase(w)) {
                    answer+=(char) (155 - (int) w);
                } else {
                    answer+=(char) (219 - (int) w);
                }
            }
        }
        return answer;
    }
}
