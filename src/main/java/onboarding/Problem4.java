package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int num = 0;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            num = (int) c;
            if (Character.isUpperCase(c)) {
                num = 155 - num;
            } else if (Character.isLowerCase(c)) {
                num = 219 - num;
            }
            answer += (char) num;
        }

        return answer;
    }
}
