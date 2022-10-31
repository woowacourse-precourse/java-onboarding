package onboarding;

import java.util.Scanner;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        for(int i=0;i<cryptogram.length()-1;i++){
            char first = cryptogram.charAt(i);
            char second = cryptogram.charAt(i+1);
            String duplication = "";
            if(first == second){
                duplication += first;
                duplication += second;
                cryptogram.replace(duplication,"");
                i=0;
            }
        }

        answer = cryptogram;

        return answer;
    }

}
