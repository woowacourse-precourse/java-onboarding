package onboarding;

import java.time.temporal.ChronoField;

public class Problem4 {
    public static String solution(String word) {
        String answer = translate(word);
        return answer;
    }
    public static String translate(String word){
        StringBuilder sb = new StringBuilder();

        for (int len = word.length(),i=0;i<len;i++){
            char c = word.charAt(i);
            c = translator(c);
            sb.append(c);
        }
        return sb.toString();
    }

    public static char translator(char cha){

        if (Character.isUpperCase(cha)){
            return (char)('Z' - cha + 'A');
        }

        else if(Character.isLowerCase(cha)){
            return (char)('z' - cha + 'a');
        }

        return cha;
    }

}
