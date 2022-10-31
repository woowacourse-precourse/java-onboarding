package onboarding;

/*
========================================Problem4 기능 목록========================================
- 문자열을 문자열 배열로 변환하는 기능
- 해당 문자가 알파벳인지 확인하는 기능
- 알파벳을 반대로 변환하는 기능
- 문자열 배열을 문자열로 변환하는 기능
 */

public class Problem4 {
    public static char[] convertStringToArray(String str){
        return str.toCharArray();
    }

    public static String convertArrayToString(char[] chrArray){
        return new String(chrArray);
    }

    public static boolean isAlpha(char chr){
        return (chr >= 'a' && chr <= 'z') && (chr >= 'A' && chr <= 'Z');
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
