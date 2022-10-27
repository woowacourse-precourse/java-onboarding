package onboarding;

public class Problem4 {
    public static final char LOWERCASE_BASE = 'a';
    public static final char LOWERCASE_ENCRYPTED_BASE = 'z';
    public static final char UPPDERCASE_BASE = 'A';
    public static final char UPPERCASE_ENCRYPTED_BASE = 'Z';

    public static char reverseCharacter(char target){
        char reversedCharacter = target;
        /*if(isLowerCase(target)){
            encryptedCharacter = (char)(LOWERCASE_BASE - target + LOWERCASE_ENCRYPTED_BASE);
        }
        if(isUppderCase(target)){
            encryptedCharacter = (char)(UPPDERCASE_BASE - target + UPPERCASE_ENCRYPTED_BASE);
        }*/
        reversedCharacter = (char)(UPPDERCASE_BASE - target + UPPERCASE_ENCRYPTED_BASE);
        return reversedCharacter;
    }

    public static boolean isLowerCase(char target){
        boolean result = false;
        if(target >= 'a' && target <= 'z'){
            result = true;
        }
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++){
            char currentCharacter = word.charAt(i);
            //answer = answer + changeCharacter(currentCharacter);
        }
        return answer;
    }
}
