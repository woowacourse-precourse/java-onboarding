package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        int pointer = 0 ;
        List<String> charList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        while (pointer>=0 && pointer < charList.size()-1){
            String now = charList.get(pointer);
            if(!now.equals(charList.get(pointer+1))){
                pointer += 1 ;
            }else {
                cryptCharList(pointer, charList);
                pointer -= 1;
            }
        }
        return String.join("",charList);
    }
    private static void cryptCharList(int pointer, List<String> charList){
        while(pointer < charList.size()-1 && charList.get(pointer).equals(charList.get(pointer+1))){
            charList.remove(pointer);
            charList.remove(pointer);
        }
    }
}
