package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){
            answer += isAlphabet(word.charAt(i));
        }
        return answer;
    }

    public static char isAlphabet(char letter){
        String something = Character.toString(letter);
        if(something.matches("[a-zA-Z]")){
            return convertAlphabet(letter);
        }
        if(something.matches("[^a-zA-Z]")){
            return letter;
        }
        return '@';
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