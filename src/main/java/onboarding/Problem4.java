package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

class AlphabetController{
    static final int UPPER_START_INDEX = 65;
    static final int UPPER_END_INDEX = 90;
    static final int LOWER_START_INDEX = 97;
    static final int LOWER_END_INDEX = 122;

    private static boolean isUpperAlpha(char alpha){
        return ((int)alpha >= UPPER_START_INDEX && (int)alpha <= UPPER_END_INDEX);
    }
}