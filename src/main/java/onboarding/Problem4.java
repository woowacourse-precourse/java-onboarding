package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FrogDictionary{
    static final char FIRST_ALPHABET='a';
    static final char LAST_ALPHABET='z';
    static final int NUMBER_OF_ALPHABET=26;

    char[] makeAlphabetArray(){
        char[] alphabetArray=new char[NUMBER_OF_ALPHABET];
        for(int order=0;order<NUMBER_OF_ALPHABET;order++){
            alphabetArray[order] = (char)((int)FIRST_ALPHABET + order);
        }
        return alphabetArray;
    }
    char[] makeFrogLetterArray(){
        char[] frogLetter=new char[NUMBER_OF_ALPHABET];

        for(int order=0;order<NUMBER_OF_ALPHABET;order++){
            frogLetter[order] = (char)((int)LAST_ALPHABET - order);
        }
        return frogLetter;
    }
    HashMap<Character, Character> makeDictionary(char[] alphabetArray, char[] frogLetterArray){
        HashMap<Character, Character> frogDictionary=new HashMap<>();
        for(int position=0;position<NUMBER_OF_ALPHABET;position++){
            frogDictionary.put(alphabetArray[position], frogLetterArray[position]);
        }
        return frogDictionary;
    }
}
class Translation{
    boolean isUpperLetter(char letter){
        final char LAST_CAPITAL_LETTER='Z';
        return ((int)letter)>=((int)LAST_CAPITAL_LETTER);
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
