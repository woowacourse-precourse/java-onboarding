package onboarding;

public class Problem4 {
    //  Static-Variable
    private static final int ASCII_CODE_a = 97;
    private static final int ASCII_CODE_A = 65;
    private static final int ASCII_CODE_ZtoA = 25;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    //  입력값에 대한 유효성 검사
    private static Boolean verifyChar(char input){
        if(!Character.isAlphabetic(input)) return false;
        return true;
    }
}
