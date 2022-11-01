package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        HashSet<Integer> set = dup(cryptogram);
        ArrayList<Integer> arr;
        while(!set.isEmpty()){
            if(set.size()==2 && cryptogram.length()==2)
                return "";
            String s = "";
            for(int i=0;i<cryptogram.length();i++){
                if(!set.contains(i)){
                    s += cryptogram.charAt(i);
                }
            }
            cryptogram = s;
            set = dup(cryptogram);
        }
        return cryptogram;
    }
    public static HashSet<Integer> dup(String s){ //중복 index
        HashSet<Integer> set = new HashSet<>();
        char prev = s.charAt(0);
        for (int i=1;i<s.length();i++){
            char n = s.charAt(i);
            if(prev == n) {
                set.add(i);
                set.add(i - 1);
            }
            prev = n;
        }
        return set;
    }
}
