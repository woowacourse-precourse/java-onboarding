package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder swap_answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char word_digit = word.charAt(i);
            if (word_digit >= 'a' && word_digit <= 'z') {
                swap_answer.append((char) ('z' - (word_digit - 'a')));
            } else if (word_digit >= 'A' && word_digit <= 'Z') {
                swap_answer.append((char) ('Z' - (word_digit - 'A')));
            } else
                swap_answer.append(word_digit);
        }

        answer = swap_answer.toString();
        return answer;
    }
}
