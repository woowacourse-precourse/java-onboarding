package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] strarr = word.toCharArray();

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
    public static void main(String[] args) {
        solution2("abc");
        System.out.println(123);
    }
}
