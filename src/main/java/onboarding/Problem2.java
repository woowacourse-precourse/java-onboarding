package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        
        HashSet<Integer> temp = findSameCharsIdx(cryptogram);
        return answer;

    }
    private static HashSet<Integer> findSameCharsIdx(String cryptogram){
        HashSet<Integer> idxList= new HashSet<Integer>();

        for (int i=0;i<cryptogram.length()-1;i++){
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                idxList.add(i);
                idxList.add(i+1);
            }
        }

        return idxList;
    }
}
