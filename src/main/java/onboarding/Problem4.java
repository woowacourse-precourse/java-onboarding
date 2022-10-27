package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        Hashtable <Character, Character> hashtable = new Hashtable<>();
        int it = 0;
        for(char c = 'a' ; c <= 'z'; c++) hashtable.put(c, (char)('z' - it++));
        it = 0;
        for(char c = 'A' ; c <= 'Z'; c++) hashtable.put(c, (char)('Z' - it++));

        String answer = "";
        for(char c : word.toCharArray()){
            if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))   answer += hashtable.get(c);
            else    answer += c;
        }
        return answer;
    }
}
