package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }


    public static char convertAlphabet(char letter){
        String alphabet = Character.toString(letter);
        if(alphabet.matches("[a-z]")){
            int number = 219 - letter;
            return (char)number;
        }
        if(alphabet.matches("[A-Z]")){
            int number = 155 - letter;
            return (char)number;
        }
        return '@';
    }

}