package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int wordIterator = 0; wordIterator < word.length(); wordIterator++) {
            if (word.charAt(wordIterator) >= 'A' && word.charAt(wordIterator) <= 'Z') {
                answer.append((char) (90 - ((int) word.charAt(wordIterator) - 65)));
            }

            else if (word.charAt(wordIterator) >= 'a' && word.charAt(wordIterator) <= 'z') {
                answer.append((char) (122 - ((int) word.charAt(wordIterator) - 97)));
            }

            else answer.append(word.charAt(wordIterator));
        }

        return answer.toString();
    }
}
