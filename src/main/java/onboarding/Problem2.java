package onboarding;

import java.util.Stack;

import static onboarding.Problem2.Const.*;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = cryptogram;

        if (isWrongLength(cryptogram)){
            throw new IllegalArgumentException("문자열 길이는 1이상 1000 이하입니다.");
        }

        if (isNotAllLowerCase(cryptogram)){
            throw new IllegalArgumentException("모든 문자열은 소문자만 가능합니다.");
        }

        while (hasConsecutiveChar(cryptogram)) {
            cryptogram = removeDupChar(cryptogram);
            answer = cryptogram;
        }

        return answer;
    }

    private static Boolean hasConsecutiveChar(String checkString){
        if (isEmptyString(checkString)){
            return false;
        }

        char cmpChar = 0;
        for (int i=0; i<checkString.length(); i++){
            char curChar = checkString.charAt(i);
            if (isSameCharacter(cmpChar, curChar)){
                return true;
            }
            cmpChar = curChar;
        }
        return false;
    }

    private static String removeDupChar(String inputString){
        Stack<Character> stack = new Stack<>();

        char lastPopChar = 0;
        for (int i=0; i<inputString.length(); i++){
            char curChar = inputString.charAt(i);

            if (isSameWithStackTop(stack, curChar)){
                lastPopChar = stack.pop();
            } else{
                pushChar(stack, lastPopChar, curChar);
                lastPopChar = curChar;
            }
        }
        return stackToString(stack);
    }

    private static boolean isSameWithStackTop(Stack<Character> stack, char curChar) {
        return stack.size() > 0 && isSameCharacter(stack.peek(), curChar);
    }

    private static void pushChar(Stack<Character> stack, char lastPopChar, char curChar) {
        if (curChar != lastPopChar){
            stack.push(curChar);
        }
    }

    private static String stackToString(Stack<Character> stack) {
        String retString = "";
        for (Character character : stack){
            retString += String.valueOf(character);
        }

        return retString;
    }

    private static boolean isSameCharacter(char cmpChar, char curChar) {
        return cmpChar == curChar;
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
