package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";
        ArrayList<String> answerArr = new ArrayList<>();

        char[] chArr = word.toCharArray(); // String -> char

        for(char oldChar: chArr){
            char newChar = convertAlphabet(oldChar);
            answerArr.add(Character.toString(newChar));
        }

        // join answer array and get answer
        answer = String.join("", answerArr);

        return answer;
    }

    private static char convertAlphabet(char asciiValue) {
        int decimalValue = asciiValue; // char -> int
        // convert Alphabets
        if(decimalValue >= 65 && decimalValue <= 90){
            // Alphabet Upper Case
            decimalValue = 155 - decimalValue;
        }else if(decimalValue >= 97 && decimalValue <= 122){
            // Alphabet Lower Case
            decimalValue = 219 - decimalValue;
        }
        char newChar = (char) decimalValue;
        return newChar;
    }
}
