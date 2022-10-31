package onboarding;

import problem4.ReverseWord;

public class Problem4 {
    public static String solution(String word) {
        ReverseWord reverseWord = new ReverseWord(word);
        String answer = reverseWord.reverse();
        return answer;
    }
}
