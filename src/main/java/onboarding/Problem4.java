package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            char letter = word.charAt(i);
            if(!checkAlphabet(letter)){
                answer+=letter;
            }
            if(Character.isUpperCase(letter)){
                answer += convertUpperCaseLetterReverse(letter);
            }
            if(Character.isLowerCase(letter)){
                answer += convertLowerCaseLetterReverse(letter);
            }
        }
        return answer;
    }

    public static String convertUpperCaseLetterReverse(char letter){
        return Character.toString((char)(155 - letter));
    }

    public static String convertLowerCaseLetterReverse(char letter){
        return Character.toString((char)(219 - letter));
    }

    public static boolean checkAlphabet(char letter){
        String pattern = "^[a-zA-Z]*$";
        if(Pattern.matches(pattern, String.valueOf(letter))){
            return true;
        }
        return false;
    }
}
