package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(CheckCryptogram(cryptogram)){
            return CheckDuplicates(cryptogram).toString();
        }
        return "0";
        //throw new IllegalArgumentException();
    }

    /* 기능1 : input 예외 확인 */
    private static boolean CheckCryptogram(String str){
        if(isLower(str) && isInRange(str) )return true;
        return false;
    }

    private static boolean isLower(String str){
        char[] charArray = str.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if( !(Character.isLowerCase(charArray[i]))){
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(String str){
        if(str.length() > 0 && str.length() < 1001) return true;
        return false;
    }

    /* 기능2 : 중복 문자 탐색 */
    private static List<Integer> CheckDuplicates(String str){
        char tmp = '0';
        List<Integer> duplicatelist = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(tmp == str.charAt(i)){
                duplicatelist.add(i-1);
                duplicatelist.add(i);
            }
            tmp = str.charAt(i);
        }
        return duplicatelist;
    }
}
