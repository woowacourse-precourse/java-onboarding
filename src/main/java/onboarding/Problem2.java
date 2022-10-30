package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    // 1. cryptogram 예외사항 검사함수 만들기
    // cryptogram이 대문자가 들어간 경우거나 길이가 1~1000을 벗어난 경우 false return
    public static boolean isException(String cryptogram){
        if(cryptogram.length() > 1000 || cryptogram.length() < 1){ // 길이가 1~1000을 벗어난 경우 false return
            return false;
        } else if(isUpperCase(cryptogram)){ // 대문자가 있는 경우 false return
            return false;
        }
        return true;
    }

    // 대문자 검사 함수.
    public static boolean isUpperCase(String cryptomgram){
        for(int i = 0; i < cryptomgram.length(); i++){
            if(cryptomgram.charAt(i) == cryptomgram.toUpperCase().charAt(i)){ // 대문자가 있는 경우 true return
                return true;
            }
        }
        return false;
    }

    // 2.중복이 있는지 체크하는 함수.
    public static boolean isDuplicate(String cryptomgram){
        if(cryptomgram != null){
            for(int i = 1; i < cryptomgram.length(); i++){
                if(cryptomgram.charAt(i-1) != 0){
                    if(cryptomgram.charAt(i) == cryptomgram.charAt(i-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 중복이 있다면 제거하는 함수.
    public static String removeDuplicate(String cryptogram){
        if(cryptogram == null){
            return "";
        }
        char[] chars = cryptogram.toCharArray();
        char prev = 0;
        int k = 0;
        String result = "";

        for(char c : chars){
            if(prev != c){
                chars[k++] = c;
                prev = c;
            }
            else{
                // 길이가 2보다 작은데 중복인 경우 "" return
                if(chars.length <= 2){
                    return result;
                }
                chars[k--] = chars[k+2];
            }
        }
        System.out.println("k : " + k);
        System.out.println("sub 전 : " + new String(chars));
        result = new String(chars).substring(0, k);
        System.out.println("sub 후 : " + result);
        if(isDuplicate(result)){
            return removeDuplicate(result);
        }
        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        if(isException(cryptogram)){
            // 중복제거 함수를 통해서 중복제거 하기.
            if(isDuplicate(cryptogram)){
                answer = removeDuplicate(cryptogram);
                return answer;
            }
            answer = cryptogram;
        }

        return answer;
    }
}
