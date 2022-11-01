package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = removeDuplication(cryptogram);

        return answer;
    }//public static String solution

    public static String removeDuplication(String cryptogram){
        char recentChar = 0;

        for(int i = 1; i < cryptogram.length(); i++){
            recentChar = cryptogram.charAt(i);

            if(i == 1 && recentChar == cryptogram.charAt(0)){
                if(cryptogram.length() == 2) {
                    cryptogram = "";
                    break;
                }
                cryptogram = cryptogram.substring(i+1);
            }

            if(i != 1 && recentChar == cryptogram.charAt(i-1)){
                cryptogram = cryptogram.substring(0,i-1) + cryptogram.substring(i+1);
                i -= 2;
            }
        }
        return cryptogram;
    }//public static String removeDuplication

}//public class Problem2
