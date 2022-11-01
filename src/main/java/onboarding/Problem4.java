package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isUpperCase(word.charAt(i))) {
                sb.append(upper.charAt(25 - upper.indexOf(word.charAt(i))));
            } else if (Character.isLowerCase(word.charAt(i))) {
                sb.append(lower.charAt(25 - lower.indexOf(word.charAt(i))));
            } else {
                sb.append(word.charAt(i));
            }
        }
        return answer;
    }
}
