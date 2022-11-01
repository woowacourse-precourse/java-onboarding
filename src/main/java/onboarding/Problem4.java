package onboarding;

import java.util.Map;

public class Problem4 {
    public static String solution(String word) {


        StringBuilder builder = new StringBuilder(word);
        for(int i=0;i<builder.length();i++){

            char targetChar = builder.charAt(i);

            if(targetChar == ' ')
                continue;

            targetChar = alternateChar(targetChar);
            builder.setCharAt(i,targetChar);
        }

        return builder.toString();
    }

    public static char alternateChar(char targetChar){

        char alternatedChar;
        if(Character.isUpperCase(targetChar)){
            alternatedChar = (char) ('A' + ('Z' - targetChar));
        }

        else{
            alternatedChar = (char) ('a' + ('z' - targetChar));
        }

        return alternatedChar;
    }
}
