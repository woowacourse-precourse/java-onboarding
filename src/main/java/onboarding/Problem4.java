package onboarding;

import java.util.HashMap;

class FrogDictionary{
    final char FIRST_ALPHABET='a';
    final int NUMBER_OF_ALPHABET=26;
    HashMap<Character, Character> frogDictionary;

    char[] makeAlphabetArray(){
        char[] alphabetArray=new char[NUMBER_OF_ALPHABET];
        for(int i=0;i<NUMBER_OF_ALPHABET;i++){
            alphabetArray[i] = (char)((int)FIRST_ALPHABET + i);
        }
        return alphabetArray;
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
