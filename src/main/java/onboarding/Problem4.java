package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<String> answerArr = new ArrayList<>();

        char[] chArr = word.toCharArray();
        for(char oldChar: chArr){
            System.out.println(oldChar);
            int ascii = oldChar;
            System.out.println(ascii);
            if(ascii >= 65 && ascii <= 90){
                // Alphabet Upper Case
                ascii = 155 - ascii;
            }else if(ascii >= 97 && ascii <= 122){
                // Alphabet Lower Case
                ascii = 219 - ascii;
            }
            System.out.println(ascii);
            char newChar = (char) ascii;
            answerArr.add(Character.toString(newChar));
        }

        System.out.println(answerArr);
        answer = String.join("", answerArr);


        return answer;
    }
}
