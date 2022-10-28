package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> upperConvert=new HashMap<>();
    private static final HashMap<Character, Character> lowerConvert=new HashMap<>();
    private static final int UPPER=1;
    private static final int LOWER=2;
    private static final int NOTTHING=0;
    public static String solution(String word) {
        StringBuilder answer=new StringBuilder();
        setConvert();
        for(int i=0;i<word.length();i++){
            answer.append(converter(word.charAt(i)));
        }
        return answer.toString();
    }
    public static char converter(char c){
        int type=checkLowerUpper(c);
        if(type==UPPER)
            c=upperConvert.get(c);
        if(type==LOWER)
            c=lowerConvert.get(c);
        return c;
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
