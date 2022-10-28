package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public static String removeDuplicate(String str) {
        int count = 0;
        String answer = str;

        while(true) {
            String temp = "";
            HashMap<Integer,Integer> duplicateIndexList = checkNearDuplicate(answer);
            char[] chars = answer.toCharArray();

            if(duplicateIndexList.size() == 0) break;

            for(int i = 0; i < chars.length; i++) {
                if(duplicateIndexList.containsKey(i) == false){
                    temp += Character.toString(chars[i]);
                }
            }

            answer = temp;
            count ++;
        }
        return answer;
    }
    public static HashMap<Integer,Integer> checkNearDuplicate(String str) {
        HashMap<Integer,Integer> duplicateIndexList = new HashMap<>();
        char[] chars = str.toCharArray();
        for(int index = 1; index < chars.length; index++) {
            if(chars[index] == chars[index-1]){
                duplicateIndexList.put(index-1,1);
                duplicateIndexList.put(index,1);
            }
        }
        return duplicateIndexList;
    }
    public static String solution(String cryptogram) {
        String answer = removeDuplicate(cryptogram);
        return answer;
    }
}
