package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {

        ArrayList<String> answerArr = new ArrayList<>();

        char[] chArr = word.toCharArray(); // String -> char

        for(char oldChar: chArr){
            char newChar = convertAlphabet(oldChar);
            answerArr.add(Character.toString(newChar));
        }

        // join answer array and get answer
        String answer = String.join("", answerArr);

        return answer;
    }

    private static char convertAlphabet(char charValue) {
        int intValue = charValue; // char -> int (자동변환)
        // convert Alphabets
        if(intValue >= 65 && intValue <= 90){
            // Alphabet Upper Case
            intValue = 155 - intValue;
        }else if(intValue >= 97 && intValue <= 122){
            // Alphabet Lower Case
            intValue = 219 - intValue;
        }
        char newChar = (char) intValue; // int -> char (강제변환)
        return newChar;
    }
}
