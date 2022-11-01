package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FrogDictionary{
    static final char FIRST_ALPHABET='a';
    static final char LAST_ALPHABET='z';
    static final int NUMBER_OF_ALPHABET=26;
    static final int ALPHABET=0;
    static final int FROG_LETTER=1;
    static final int INITIALIZER=0;
    static final List<List<String>> hashMaterials=new ArrayList<>();
    static final HashMap<String, String> FROG_DICTIONARY=new HashMap<>();
    FrogDictionary(){
        makeAlphabetArray();
        makeFrogLetterArray();
        makeDictionary();
    }
    void makeAlphabetArray(){
        List<String> alphabetArray=new ArrayList<>();
        for(int order=INITIALIZER;order<NUMBER_OF_ALPHABET;order++){
            alphabetArray.add(String.valueOf((char)((int)FIRST_ALPHABET + order)));
        }
        hashMaterials.add(alphabetArray);
    }
    void makeFrogLetterArray(){
        List<String> frogLetter=new ArrayList<>();

        for(int order=INITIALIZER;order<NUMBER_OF_ALPHABET;order++){
            frogLetter.add(String.valueOf((char)((int)LAST_ALPHABET - order)));
        }
        hashMaterials.add(frogLetter);
    }
    void makeDictionary(){
        List<String> alphabetArray = hashMaterials.get(ALPHABET);
        List<String> frogLetterArray = hashMaterials.get(FROG_LETTER);

        for(int position=INITIALIZER;position<NUMBER_OF_ALPHABET;position++){
            FROG_DICTIONARY.put(alphabetArray.get(position), frogLetterArray.get(position));
        }
    }
    boolean isUpperLetter(String letter){
        return letter.matches("^[A-Z]*$");
    }
    String getFrogLetter(String letter){
        String frogLetter;
        if(isUpperLetter(letter)){
            String lowerLetter=letter.toLowerCase();
            frogLetter=FROG_DICTIONARY.get(lowerLetter);
            return frogLetter.toUpperCase();
        }
        else{
            return FROG_DICTIONARY.get(letter);
        }
    }
}
class Translation{

    boolean isAlphabet(String letter){
        return letter.matches("^[a-zA-Z]*$");
    }
    String translate(String letter,  FrogDictionary frogDictionary){
        String translatedLetter;
        if(isAlphabet(letter)){
            translatedLetter=frogDictionary.getFrogLetter(letter);
        }
        else{
            translatedLetter=letter;
        }
        return translatedLetter;
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer;
        List<String> frogLetterArray=new ArrayList<>();

        FrogDictionary frogDictionary = new FrogDictionary();
        frogDictionary.makeDictionary();

        Translation translation = new Translation();
        for(String letter: word.split("")){
            frogLetterArray.add(translation.translate(letter, frogDictionary));
        }

        answer=String.join("",frogLetterArray);
        return answer;
    }
}
