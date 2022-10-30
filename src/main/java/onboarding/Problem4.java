package onboarding;

import static onboarding.Problem4.Const.*;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        if (isWrongLength(answer)){
            throw new IllegalArgumentException("1 이상 1000 이하의 길이를 가진 문자열이어야 합니다.");
        }

        return answer;
    }

    private static Boolean isUpperAlpha(char ch){
        return (A_ASCII_VALUE <= ch && ch <= Z_ASCII_VALUE);

    }

    private static Boolean isLowerAlpha(char ch){
        return (a_ASCII_VALUE <= ch && ch <= z_ASCII_VALUE);
    }

    private static boolean isWrongLength(String checkString){
        int length = checkString.length();
        return (length < 1 || length > 1000);
    }

    static class Const{
        public static final int A_ASCII_VALUE = 65;
        public static final int Z_ASCII_VALUE = 90;

        public static final int a_ASCII_VALUE = 97;
        public static final int z_ASCII_VALUE = 122;

        public static final int UPPER_ASCII_SUM = A_ASCII_VALUE + Z_ASCII_VALUE;
        public static final int LOWER_ASCII_SUM = a_ASCII_VALUE + z_ASCII_VALUE;
    }
}
