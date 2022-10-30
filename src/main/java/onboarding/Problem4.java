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
        return (A_VALUE <= ch && ch <= Z_VALUE);

    }

    private static Boolean isLowerAlpha(char ch){
        return (a_VALUE <= ch && ch <= z_VALUE);
    }

    private static boolean isWrongLength(String checkString){
        int length = checkString.length();
        return (length < 1 || length > 1000);
    }

    static class Const{
        public static final int A_VALUE = 65;
        public static final int Z_VALUE = 90;

        public static final int a_VALUE = 97;
        public static final int z_VALUE = 122;

        public static final int UPPER_ALPHA_SUM = 155;
        public static final int LOWER_ALPHA_SUM = 219;
    }
}
