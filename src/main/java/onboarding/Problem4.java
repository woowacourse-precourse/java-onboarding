package onboarding;

public class Problem4 {
    public static final char LOWERCASE_BASE = 'a';
    public static final char LOWERCASE_ENCRYPTED_BASE = 'z';
    public static final char UPPERCASE_BASE = 'A';
    public static final char UPPERCASE_ENCRYPTED_BASE = 'Z';

    public static char reverseCharacter(char target){
        char reversedCharacter = target;
        if(isLowerCase(target)){
            reversedCharacter = (char)(LOWERCASE_BASE - target + LOWERCASE_ENCRYPTED_BASE);
        }
        if(isUpperCase(target)){
            reversedCharacter = (char)(UPPERCASE_BASE - target + UPPERCASE_ENCRYPTED_BASE);
        }
        return reversedCharacter;
    }

    public static boolean isLowerCase(char target){
        return (target >= 'a' && target <= 'z');
    }

    public static boolean isUpperCase(char target){
        return (target >= 'A' && target <= 'Z');
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char currentCharacter = word.charAt(i);
            answer.append(reverseCharacter(currentCharacter));
        }
        return answer.toString();
    }
}
