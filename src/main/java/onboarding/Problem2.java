package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        result = checkString(cryptogram);
        return result;
    }
    static String checkString(String str) {
        while(validCheck(str)){
            str = catchSameIndex(str);
        }

        return str;
    }
    static String catchSameIndex(String str){
        List<Integer> index = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                index.add(i);
                index.add(i+1);
            }
        }
        return splitString(str, index);
    }
    static String splitString(String str, List<Integer> index) {
        String newstring = "";
        for(int i=0; i<str.length(); i++) {
            if(checkIndex(i,index)) continue;
            newstring += str.charAt(i);
        }
        index.clear();
        //if(index!=str.length()-2) newstring += str.charAt(str.length()-1);
        return newstring;
    }
    static boolean checkIndex(int num, List<Integer> index){
        for(int i=0; i<index.size(); i++){
            if(num==index.get(i)) return true;
        }
        return false;
    }

    static boolean validCheck(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)) return true;
        }
        return false;
    }
}
