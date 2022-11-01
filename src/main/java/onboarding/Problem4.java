package onboarding;

public class Problem4 {

    static StringBuilder sb = new StringBuilder();
    public static String solution(String word) {
        if (wordLengthOutOfRangeException(word)) {
            return word;
        }
        return mergeConvertedCharacters(word);
    }

    public static char upperCaseConversion(char character) {
        return (char) (155 - character);
    }

    public static char lowerCaseConversion(char character) {
        return (char) (219 - character);
    }
}