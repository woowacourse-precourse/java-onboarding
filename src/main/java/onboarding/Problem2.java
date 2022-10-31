package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean chk = true;

        while (chk){
            List<Integer> arr = dupCk(cryptogram);
            if(arr.size() == 0){
                chk = false;
            }else{
                int move = 0;
                for(int idx : arr){
                    cryptogram = cryptogram.substring(0,idx+move) + cryptogram.substring(idx+move+2);
                    move = -2;
                }
            }
        }
        answer = cryptogram;
        return answer;
    }

    private static List<Integer> dupCk(String str){

        List<Integer> dupList = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dupList.add(i);
            }
        }
        return dupList;
    }
}
