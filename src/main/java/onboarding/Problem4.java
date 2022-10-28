package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> upperConvert=new HashMap<>();
    private static final HashMap<Character, Character> lowerConvert=new HashMap<>();
    private static final int UPPER=1;
    private static final int LOWER=2;
    private static final int NOTTHING=0;
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

    public static int checkLowerUpper(char c){
        if(Character.isUpperCase(c))
            return UPPER;
        if(Character.isLowerCase(c))
            return LOWER;
        return NOTTHING;
    }
}
