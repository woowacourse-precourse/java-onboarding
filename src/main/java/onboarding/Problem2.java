package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        result = checkString(cryptogram);
        return result;
    }
    public static String checkString(String cryptogram) {
        while(validCheck(cryptogram)){
            cryptogram = catchSameIndex(cryptogram);
        }
        return cryptogram;
    }
    public static String catchSameIndex(String string){
        List<Integer> index = new ArrayList<>();
        for(int i=0; i<string.length()-1; i++) {
            if(string.charAt(i) == string.charAt(i+1)) {
                index.add(i);
                index.add(i+1);
            }
        }
        return splitString(string, index);
    }
    public static String splitString(String string, List<Integer> index) {
        String newstring = "";
        for(int i=0; i<string.length(); i++) {
            if(checkIndex(i,index)) continue;
            newstring += string.charAt(i);
        }
        index.clear();
        return newstring;
    }
    private static boolean checkIndex(int num, List<Integer> index){
        for(int i=0; i<index.size(); i++){
            if(num==index.get(i)) return true;
        }
        return false;
    }
    private static boolean validCheck(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)) return true;
        }
        return false;
    }
}
