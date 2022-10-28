package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
             result += checkWord(word.charAt(i));
        }

        return result;
    }

    private static char checkWord(char word) {
        if (word >= 'A' && word <= 'Z') {
            changeWord(word);
        }

        if (word >= 'a' && word <= 'z') {
            changeWord(word);
        }

        return word;
    }
}
