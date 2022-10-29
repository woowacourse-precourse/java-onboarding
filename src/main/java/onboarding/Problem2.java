package onboarding;

import java.util.HashMap;

public class Problem2 {
    public static String removeDuplicateLoop(String str) {
        String answer = str;

        while(checkNearDuplicate(answer).size() != 0) {
            answer = removeDuplicate(answer);
        }
        return answer;
    }
    public static String removeDuplicate(String str) {
        String temp = "";
        HashMap<Integer,Integer> duplicateIndexList = checkNearDuplicate(str);
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(duplicateIndexList.containsKey(i) == false){
                temp += Character.toString(chars[i]);
            }
        }
        return temp;
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
        String answer = removeDuplicateLoop(cryptogram);
        return answer;
    }
}
