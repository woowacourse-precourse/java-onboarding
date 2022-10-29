package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<String,String> words = changeAlpha();
        for(int i=0;i<word.length();i++){
            if (String.valueOf(word.charAt(i)).isBlank()){
                answer+=" ";
            } else{
                answer+=words.get(String.valueOf(word.charAt(i)));
            }
        }
        return answer;
    }
    public static HashMap<String,String> changeAlpha(){
        HashMap<String,String> words = new HashMap<String,String>();
        int ascii = 90;
        for(int i=65;i<=90;i++){
            words.put(String.valueOf((char)i),String.valueOf((char)ascii));
            ascii-=1;
        }
        ascii = 122;
        for(int i=97;i<=122;i++){
            words.put(String.valueOf((char)i),String.valueOf((char)ascii));
            ascii-=1;
        }
        return words;
    }
}
