package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char finalChangeCharacter(char c){
        if(c>='A' && c<='Z'){
            return changeCharacter(c);
        }
        else if(c>='a' && c<='z'){
            c = changeUpperCase(c);
            char tmp = changeCharacter(c);
            return changeLowerCase(tmp);
        }
        else{
            return c;
        }
    }

    public static char changeCharacter(char c) {
        return (char) (155 - c);
    }

    public static char changeUpperCase(char c) {
        return (char) (c - 32);
    }

    public static char changeLowerCase(char c) {
        return (char) (c + 32);
    }


}
