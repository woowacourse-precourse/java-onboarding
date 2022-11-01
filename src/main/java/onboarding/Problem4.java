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

    //  입력된 문자를 변환하는 메소드
    private static Character convertChar(char input){
        // Edge-Case
        if(!verifyChar(input)) return input;

        int index = Math.abs(ASCII_CODE_ZtoA - findCharIndex(input));
        int base = getBase(input);

        return (char) (base + index);
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

    //  알파벳 Index 찾기 메소드
    private static int findCharIndex(char input){
        int base = getBase(input);
        return (int) input - base;
    }

    //  입력값에 따라 a,A의 아스키 코드 리턴 메소드
    private static int getBase(char input) {
        if(checkLowerCase(input))
            return ASCII_CODE_a;
        return ASCII_CODE_A;
    }

    //  입력값에 대한 유효성 검사
    private static Boolean verifyChar(char input){
        if(!Character.isAlphabetic(input)) return false;
        return true;
    }
}
