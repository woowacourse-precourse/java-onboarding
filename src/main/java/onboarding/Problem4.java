package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder StringBuilderWord = new StringBuilder();
        int wordLength = word.length();
        char frogWord = ' ';

        for (int i = 0; i < wordLength; i++) {
            char nowChar = word.charAt(i);

            if (nowChar < 'A' || nowChar > 'z' || (nowChar > 'Z' && nowChar < 'a')) {
                frogWord = nowChar;
            }
            if ('A' <= nowChar && nowChar <= 'Z') {
                int reversedIndex = 155 - (int) nowChar;
                frogWord = (char) reversedIndex;
            }
            if ('a' <= nowChar && nowChar <= 'z') {
                int reversedIndex = 219 - (int) nowChar;
                frogWord = (char) reversedIndex;
            }
            StringBuilderWord.append(frogWord);
        }
        answer = StringBuilderWord.toString();
        return answer;
    }
}
