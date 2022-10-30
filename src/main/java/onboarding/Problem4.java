package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = frogreverseString(word);
        return answer;
    }
    public static char frogreverse(char c){
        if(65<=c && c<=90){
            c = (char)(155 - c);
        }
        else if(97<=c && c<=122){
            c = (char)(219 - c);
        }
        return c;
    }
    public static String frogreverseString(String str){
        char[] strarr = str.toCharArray();
        for(int i=0; i<strarr.length; i++){
            strarr[i] = frogreverse(strarr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(char item : strarr){
            sb.append(item);
        }
        str = sb.toString();
        return str;
    }
}
