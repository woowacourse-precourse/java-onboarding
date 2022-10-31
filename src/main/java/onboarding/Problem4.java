package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int diff = 0;
        if (!check_word_length(word))
            return "";
        for (int i = 0; i < word.length(); i++){
            answer = answer + convert_char(word.charAt(i), i);
        }
        return answer;
    }
    private static boolean check_word_length(String word) {
        if (word.length() < 1 || word.length() > 1000)
            return false;
        return true;
    }

    private static char convert_char(char word, int i) {
        int diff;
        if (word >= 65 && word <= 90) {
            diff = word - 65;
            return (char)(90 - diff);
        }
        else if (word >= 97 && word <= 122) {
            diff = word - 97;
            return (char)(122 - diff);
        }
        else
            return word;
    }
}
