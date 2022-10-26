package onboarding;

public class Problem4 {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";

    static char translate(char x) {
        char res = x;
        if (Character.isLowerCase(x)) {
            res = lower.charAt(25 - x + 'a');
        } else if (Character.isUpperCase(x)) {
            res = upper.charAt(25 - x + 'A');
        }
        return res;
    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(char cur : word.toCharArray()){
            sb.append(translate(cur));
        }
        return sb.toString();
    }
}
