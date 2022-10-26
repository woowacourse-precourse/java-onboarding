package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); ++i) {
            if (!Character.isAlphabetic(word.charAt(i)))
                answer += word.charAt(i);
            else if (Character.isUpperCase(word.charAt(i)))
                answer += (char) ('A' + 'Z' - word.charAt(i));
            else
                answer += (char) ('a' + 'z' - word.charAt(i));
        }

        return answer;
    }
}
