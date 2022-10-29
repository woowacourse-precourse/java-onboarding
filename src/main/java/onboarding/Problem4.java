package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int wordIterator = 0; wordIterator < word.length(); wordIterator++) {
            if (word.charAt(wordIterator) >= 'A' && word.charAt(wordIterator) <= 'Z') {
                answer += (char)(90 - (int)word.charAt(wordIterator) - 65);
            }

            else if (word.charAt(wordIterator) >= 'a' && word.charAt(wordIterator) <= 'z') {
                answer += (char)(122 - (int)word.charAt(wordIterator) - 97);
            }

            else answer += word.charAt(wordIterator);
        }

        return answer;
    }
}
