package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map mother = new HashMap(){{
            put('A','Z');
            put('B','Y');
            put('C','X');
            put('D','W');
            put('E','V');
            put('F','U');
            put('G','T');
            put('H','S');
            put('I','R');
            put('J','Q');
            put('K','P');
            put('L','O');
            put('M','N');
            put('N','M');
            put('O','L');
            put('P','K');
            put('Q','J');
            put('R','I');
            put('S','H');
            put('T','G');
            put('U','F');
            put('V','E');
            put('W','D');
            put('X','C');
            put('Y','B');
            put('Z','A');
        }};
        char c = ' ';
        char[] frog = new char[word.length()];
        for(int i=0;i<word.length();i++){
            c = word.charAt(i);
            if(c>='A' && c<='Z')
                frog[i] = (char)mother.get(c);
            else if(c>='a' && c<='z')
                frog[i] = (char)((char)mother.get((char)(c-32))+32);
            else
                frog[i] = c;
        }

        String answer = new String(frog);
        return answer;
    }
}
