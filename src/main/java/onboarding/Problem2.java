package onboarding;

import java.util.*;

public class Problem2 {
    // 문자열에서 연속하는 중복문자를 찾아 제거하는 함수
    public static String test(String sb){
        StringBuilder result = new StringBuilder();
        char prev = sb.charAt(0);
        int count = 0;

        for(int i=0; i<sb.length(); i++){
            if(prev == sb.charAt(i)){
                count += 1;
            }else{
                if(count < 2) result.append(prev);
                prev = sb.charAt(i);
                count = 1;
            }
        }
        if(count == 1) result.append(prev);
        return result.toString();
    }

    // 중복된 문자열이 있었는지 확인하는 함수
    public static boolean checkOverLapStr(String deletedStr, String cryptogram){
        if(deletedStr.equals(cryptogram)) return false;
        return true;
    }

    // 중복된 문자가 없을때 까지 문자열을 제거 하고 리턴하는 함수
    public static String solution(String cryptogram) {
        while (cryptogram.length()!=0){
            String deletedStr = test(cryptogram);
            if(!checkOverLapStr(deletedStr,cryptogram)) break;
            cryptogram = deletedStr;
        }
        return cryptogram;
    }
}