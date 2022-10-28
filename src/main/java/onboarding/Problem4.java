package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> upperConvert=new HashMap<>();
    private static final HashMap<Character, Character> lowerConvert=new HashMap<>();
    public static String solution(String word) {
        setConvert();
        return null;
    }

    public static void setConvert(){
        for(int i=0;i<=25;i++){
            upperConvert.put((char)(i+65),(char)(90-i));
            lowerConvert.put((char)(i+97),(char)(122-i));
        }
    }
}
