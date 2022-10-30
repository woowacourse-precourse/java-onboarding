package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> arr = overlapChar(cryptogram);
        String answer = sol(cryptogram, arr);
        return answer;
    }

    public static  ArrayList<Character> overlapChar(String cryptogram){ // 중복된 문자를 추출하는 매서드
        ArrayList<Character> arr = new ArrayList<>();

        for(int i = 0; i < cryptogram.length(); i++){
            if (arr.contains(cryptogram.charAt(i))) continue;
            for(int j = i+1; j < cryptogram.length(); j++){
                if(cryptogram.charAt(i) == cryptogram.charAt(j)){
                    arr.add(cryptogram.charAt(i));
                }
            }
        }

        return arr;
    }

    public static String sol(String cryptogram, ArrayList<Character> arr){ // 스트링에서 중복된 문자를 제거하는 매서드
        String ret_str = "";

        for(int i = 0; i < cryptogram.length(); i++){
            if(!arr.contains(cryptogram.charAt(i))){
                ret_str += cryptogram.charAt(i);
            }
            else if(Collections.frequency(arr, cryptogram.charAt(i)) % 2 == 0){
                ret_str += cryptogram.charAt(i);
                arr.remove(Character.valueOf(cryptogram.charAt(i)));
            }

        }
        return ret_str;
    }

}
