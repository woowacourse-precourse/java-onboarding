package onboarding;

import org.assertj.core.data.MapEntry;

import java.util.*;

public class Problem2 {
    public static boolean b = true;


    public static int duplicate(String str, int index){
        if(index == str.length()-1){
            return index;
        }
        if(str.charAt(index) == str.charAt(index+1)) {
            index++;
            index = duplicate(str, index);
        }
        return index;

    }
    public static String remove(String str){
        LinkedHashMap<Integer, Integer> slice = new LinkedHashMap<>();
        int i = 0;
        while( i < str.length()-1) {
            if(str.charAt(i) == str.charAt(i+1)) {
                int index = duplicate(str, i+1);

                slice.put(i, index+1);
                i = index + 1;
                b = true;
            }
            else
                i++;
        }
        List<Integer> keys = new ArrayList<>(slice.keySet());
        Collections.reverse(keys);
        for(Integer key: keys){
            str = str.substring(0, key) + str.substring(slice.get(key));
        }

        return str;
    }
    public static String solution(String cryptogram) {

        String answer = "";
        if(cryptogram.length() < 1 || cryptogram.length() > 1000) {
            answer = "cryptogram 길이는 1 이상 1000 이하 여야 합니다.";
            return answer;
        }
        if(!(cryptogram.equals(cryptogram.toLowerCase()))){
            answer = "cryptogram은 소문자로만 이루어져 있어야 합니다.";
            return answer;
        }
        while(b){
            b = false;
            cryptogram = remove(cryptogram);
        }
        b = true;
        answer = cryptogram;
        return answer;
    }
}