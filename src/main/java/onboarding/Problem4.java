package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String inputeng = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String outputeng1 = " ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String outputeng2 = " zyxwvutsrqponmlkjihgfedcba";

        char tmp = ' ';
        for (int i = 0; i < word.length(); i++) {
            if (inputeng.indexOf(word.charAt(i)) < 26) {
                tmp = outputeng1.charAt(inputeng.indexOf(word.charAt(i)));
                answer += tmp;
            } else if (inputeng.indexOf(word.charAt(i)) >= 26) {
                tmp = outputeng2.charAt(inputeng.indexOf(word.charAt(i))-26);
                answer += tmp;
            }

        }
        return answer;
    }
}