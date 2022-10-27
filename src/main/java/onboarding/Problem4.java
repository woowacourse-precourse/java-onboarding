package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String changed_word = "";
        for(int i=0; i<word.length(); i++){
            char input_character = word.charAt(i);
            if(is_alphabet(input_character)){
                changed_word += change_word(input_character);
            }
            else{
                changed_word += input_character;
            }
        }
        return changed_word;

    }

    static char change_word(char input_character){
        char changed_input = 0;
        if(Character.isUpperCase(input_character)){
            changed_input = 'Z';
            changed_input -= (input_character - 'A');
        }
        else{
            changed_input = 'z';
            changed_input -= (input_character - 'a');
        }
        return changed_input;
    }

    static boolean is_alphabet(char character){
        if(character >= 'A' && character <= 'Z') return true;
        if(character >= 'a' && character <= 'z') return true;
        return false;
    }

}
