package onboarding;

import problem4.Word;

public class Problem4 {
    public static String solution(String word) {
        Word momWord = new Word(word);
        return momWord.reverse();
    }
}
