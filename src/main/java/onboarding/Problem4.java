package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] frog = new char[58];
        for (int i = 0; i < 26; i++) {
            frog[i] = (char) ('Z' - i);
            frog[i + 32] = (char) ('z' - i);
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) c = frog[word.charAt(i) - 65];
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}
