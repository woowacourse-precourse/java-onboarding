package onboarding;

public class Problem4 {
    private static final int REVERSE_SIZE= 16;

    public static String solution(String word) {
        ConvertUtils convertUtils = new ConvertUtils(word,REVERSE_SIZE);
        return convertUtils.convertToReverseWord();
    }
}
