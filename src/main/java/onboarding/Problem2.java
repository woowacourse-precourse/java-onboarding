package onboarding;

import java.util.Stack;

import static onboarding.Problem2.Const.*;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        return answer;
    }

    private static boolean isWrongLength(String checkString){
        int length = checkString.length();
        return (length < MIN_LENGTH || length > MAX_LENGTH);
    }

    private static boolean isEmptyString(String checkString) {
        return checkString.length() == 0;
    }

    private static boolean isNotAllLowerCase(String checkString){
        for (int i=0; i<checkString.length(); i++){
            if (!isLower(checkString.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private static boolean isLower(char ch){
        return (a_VALUE <= ch && ch <= z_VALUE);
    }

    static class Const{
        public static final int MIN_LENGTH = 1;
        public static final int MAX_LENGTH = 1000;

        public static final int a_VALUE = 97;
        public static final int z_VALUE = 122;
    }
}
