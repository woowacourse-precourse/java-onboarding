package onboarding;

public class Problem4 {

    static StringBuilder sb = new StringBuilder();
    public static String solution(String word) {
        if (wordLengthOutOfRangeException(word)) {
            return word;
        }
        return mergeConvertedCharacters(word);
    }
}