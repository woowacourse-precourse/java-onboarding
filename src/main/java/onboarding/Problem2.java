package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        //연속하는 중복 문자가 없을 때까지
        while(duplicate(cryptogram)) {
            //연속하는 중복 문자 앞의 문자들과 뒤의 문자들을 저장
            for(int i=0; i<cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i)==cryptogram.charAt(i+1)) {
                    cryptogram = "" + cryptogram.substring(0, i)
                            + cryptogram.substring(i+2);
                }
            }
        }
        answer = cryptogram;

        return answer;
    }

    //연속하는 중복 문자가 있는지 검사
    public static boolean duplicate(String cryptogram) {
        for(int i=1; i<cryptogram.length(); i++) {
            if(cryptogram.charAt(i-1) == cryptogram.charAt(i)) return true;
        }
        return false;
    }
}
