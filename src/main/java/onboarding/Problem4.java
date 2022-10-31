package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        int num;
        for (int i = 0; i < word.length(); i++) {
            num = word.charAt(i);
            if (Character.isUpperCase(num)) {
                num = 155 - num;
            } else if (Character.isLowerCase(num)) {
                num = 219 - num;
            }
            answer.append((char)num);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
