package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    static Map<Character,Character> lowerCase = new HashMap<>();
    static Map<Character,Character> upperCase = new HashMap<>();
    public static String solution(String word) {
        if(checkException(word)){
            throw new IllegalArgumentException();
        }
        setMap();
        return changeWord(word);
    }
    public static void setMap(){
        int i = 97;
        int j = 122;
        int k = 65;
        int z = 90;
        while(true){
            if(i == 123){
                break;
            }
            lowerCase.put((char)i,(char)j);
            upperCase.put((char)k,(char)z);
            i++;
            j--;
            k++;
            z--;
        }
    }
    public static String changeWord(String word){
        String answer = "";
        for(int q=0; q<word.length();q++){
            if(word.charAt(q) == ' '){
                answer += " ";
            }else{
                if(Character.isUpperCase(word.charAt(q))){
                    answer += upperCase.get(word.charAt(q));
                }else{
                    answer += lowerCase.get(word.charAt(q));
                }
            }
        }
        return answer;
    }
    public static boolean checkException(String word){
        if(word == null || checkLength(word.length()) || !checkAlpa(word)){
            return true;
        }
        return false;
    }
    public static boolean checkLength(int length){
        return length < 1 || length >1000;
    }
    public static  boolean checkAlpa(String word){
        return word.matches("^[a-zA-Z\\s]*$");
    }
}
