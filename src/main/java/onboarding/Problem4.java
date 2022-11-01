package onboarding;

import static onboarding.Problem4.Const.*;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        if (isWrongLength(word)){
            throw new IllegalArgumentException("1 이상 1000 이하의 길이를 가진 단어이어야 합니다.");
        }

        for (int i=0; i<word.length(); i++){
            char curChar = word.charAt(i);
            answer += getFrogWord(curChar);
        }

        return answer;
    }

    private static String getFrogWord(char curChar){
        if (isUpperAlpha(curChar)){
            return Character.toString(UPPER_ASCII_SUM - curChar);
        }

        if(isLowerAlpha(curChar)){
            return Character.toString(LOWER_ASCII_SUM - curChar);
        }

        return Character.toString(curChar);
    }

    private static boolean isUpperAlpha(char ch){
        return (A_ASCII_VALUE <= ch && ch <= Z_ASCII_VALUE);
    }

    private static boolean isLowerAlpha(char ch){
        return (a_ASCII_VALUE <= ch && ch <= z_ASCII_VALUE);
    }

    private static boolean isWrongLength(String word){
        int length = word.length();
        return (length < WORD_MIN_LENGTH || length > WORD_MAX_LENGTH);
    }

    static class Const{
        public static final int A_ASCII_VALUE = 65;
        public static final int Z_ASCII_VALUE = 90;

        public static final int a_ASCII_VALUE = 97;
        public static final int z_ASCII_VALUE = 122;

        public static final int UPPER_ASCII_SUM = A_ASCII_VALUE + Z_ASCII_VALUE;
        public static final int LOWER_ASCII_SUM = a_ASCII_VALUE + z_ASCII_VALUE;

        public static final int WORD_MIN_LENGTH = 1;
        public static final int WORD_MAX_LENGTH = 1000;
    }
}
