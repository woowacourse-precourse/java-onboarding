package onboarding.problem4.service;

import onboarding.problem4.utils.CharType;

public class CharTypeCheckService {
    public static CharType checkCharType(char character){
        if(uppercaseCheck(character)){
            return CharType.UPPERCASE;
        }
        if(lowercaseCheck(character)){
            return CharType.LOWERCASE;
        }
        return CharType.OTHER;
    }

    private static boolean uppercaseCheck(char character){
        return (character >= 'A' && character <= 'Z');
    }

    private static boolean lowercaseCheck(char character){
        return (character >= 'a' && character <= 'z');
    }
}
