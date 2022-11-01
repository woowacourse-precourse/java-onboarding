package onboarding;

import java.util.InputMismatchException;

public class Problem4 {

    public static String solution(String word) {


        if(!isValidInput(word)){
            throw new InputMismatchException();
        }
        char[] charArrayWord = word.toCharArray();
        StringBuilder resultStringBuilder = new StringBuilder();

        for (char c : charArrayWord) {
            branchAlphabet(c, resultStringBuilder);
        }

        return resultStringBuilder.toString();
    }
    private static void branchAlphabet(char c, StringBuilder input){
        if(Character.isAlphabetic(c)){
            input.append(decoder(c));
        } else {
            input.append(c);
        }
    }

    private static boolean isValidInput(String word){
        if(word == null)
            return false;

        return word.length() > 0 && word.length() <= 1000;
    }


    private static char decoder(char input){
        char result;
        if(Character.isUpperCase(input)){
            result = decodeLowerCase(input);
        }else{
            result = decodeUpperCase(input);
        }
        return result;
    }

    private static char decodeLowerCase(int input){
        char result;
        if(input/78 < 65){
            int k = 25 - 2*(input - 65);
            result = (char)(input + k);
        }else{
            int k = 25 - 2*(90 - input);
            result = (char)(input - k);
        }
        return result;
    }

    private static char decodeUpperCase(int input){
        char result;
        if(input/110 < 97){
            int k = 25 - 2*(input - 97);
            result = (char)(input + k);
        }else{
            int k = 25 - 2*(90 - input);
            result = (char)(input - k);
        }
        return result;
    }

}
