package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        HashSet<Integer> temp = findSameCharsIdx(cryptogram);
        while (temp.size()>0){
            answer=removeCharUsingIdx(answer, temp);
            temp=findSameCharsIdx(answer);
        }

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
    private static String removeCharUsingIdx(String cryptogram, HashSet<Integer> wantToRemoveSet){
        String removedStr ="";
        for (int i=0; i< cryptogram.length();i++){
            if (!(wantToRemoveSet.contains(i))){
                removedStr+=cryptogram.charAt(i);
            }
        }
        return removedStr;
    }
}
