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

    //  입력값의 대소문자 형변환 메소드
    private static Character reverseCase(char input){
        if (checkLowerCase(input))
            return Character.toUpperCase(input);
        return Character.toLowerCase(input);
    }

    //  입력값이 소문자인지 확인하는 메소드
    private static Boolean checkLowerCase(char input){
        if(Character.toLowerCase(input) == input)
            return true;
        return false;
    }

    //  입력값에 대한 유효성 검사
    private static Boolean verifyChar(char input){
        if(!Character.isAlphabetic(input)) return false;
        return true;
    }
}
