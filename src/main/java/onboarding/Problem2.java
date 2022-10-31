package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(CheckCryptogram(cryptogram)){
            return RunGame(cryptogram);
        }
        throw new IllegalArgumentException("잘못된 입력값");
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

    /* 기능3 : 중복 문자 삭제 */
    private static String DeleteDuplicates(String str, List<Integer> duplicateslist){
        for(int i=0; i<duplicateslist.size(); i++){
            str = str.substring(0,duplicateslist.get(i)-i)+str.substring(duplicateslist.get(i)-i+1);
        }
        return str;
    }

    /* 기능4 : 중복 문자 없을 때까지 반복 */
    private static String RunGame(String cryptogram){
        List<Integer> duplicateslist = CheckDuplicates(cryptogram);
        while(duplicateslist.size() != 0){
            cryptogram = DeleteDuplicates(cryptogram,duplicateslist);
            duplicateslist = CheckDuplicates(cryptogram);
        }return cryptogram;
    }
}
