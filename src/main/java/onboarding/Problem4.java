package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
