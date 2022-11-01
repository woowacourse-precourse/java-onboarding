package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<String,String> alpha = changeAlpha();
        return changeWords(word,alpha);
    }
    public static String changeWords(String word,HashMap<String,String> words){
        String answer = "";
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
        HashMap<String,String> alpha = new HashMap<>();
        int ascii = 90;
        for(int i=65;i<=90;i++){
            alpha.put(String.valueOf((char)i),String.valueOf((char)ascii));
            ascii-=1;
        }
        ascii = 122;
        for(int i=97;i<=122;i++){
            alpha.put(String.valueOf((char)i),String.valueOf((char)ascii));
            ascii-=1;
        }
        return alpha;
    }
}
