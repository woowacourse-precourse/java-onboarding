package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = converAlpha(word.toCharArray());
        return answer;
    }

    static String converAlpha(char[] arr) {

        String answer = "";
        char temp;

        for (char c : arr) {
            if (c == 32) {
                answer += " ";
                continue;
            }
            if (Character.isUpperCase(c)) {
                temp = (char)((int)c+25 -2*((int)c-65));
                answer += Character.toString(temp);
                continue;
            }
            if (Character.isLowerCase(c)){
                temp = (char)((int)c+25 -2*((int)c-97));
                answer += Character.toString(temp);
            }
        }

        return answer;
    }
}
