package onboarding;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chArr = word.toCharArray();
        for(char c: chArr){
            System.out.println(c);
            int ascii = c;
            System.out.println(ascii);
            if(ascii >= 65 && ascii <= 90){
                // Alphabet Upper Case
                ascii = 155 - ascii;
            }else if(ascii >= 97 && ascii <= 122){
                // Alphabet Lower Case
                ascii = 219 - ascii;
            }
            System.out.println(ascii);
        }


        return answer;
    }
}
