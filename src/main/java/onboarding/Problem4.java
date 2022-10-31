package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = cast(word);
        return answer;
    }

    private static String cast(String word) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int r = 0;
            if (word.charAt(i) == ' ') {
                sb.append(word.charAt(i));
                continue;
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                r = 'A' + ('Z' - word.charAt(i));
            } else {
                r = 'a' + ('z' - word.charAt(i));
            }
            sb.append((char) r);
        }
        ans = new String(sb);
        return ans;
    }
}
