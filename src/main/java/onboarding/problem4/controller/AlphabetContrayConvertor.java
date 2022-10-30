package onboarding.problem4.controller;

import onboarding.problem4.service.AlphabetConvertService;
import onboarding.problem4.service.StringListConvertService;
import onboarding.problem4.utils.validator.StringLengthValidator;
import onboarding.problem4.utils.validator.exception.StringLengthException;
import java.util.ArrayList;

public class AlphabetContrayConvertor {
    private String originWord;
    private String convertedWord;
    private ArrayList<Character> originCharList;
    private ArrayList<Character> convertedCharList;

    public AlphabetContrayConvertor setWord(String word){
        try{
            new StringLengthValidator(word);
            this.originWord = word;
        }catch (StringLengthException e){
            e.printStackTrace();
            originWord="";
        }
        return this;
    }

    public AlphabetContrayConvertor convert(){
        originCharList = getCharListFromWord();
        convertedCharList = AlphabetConvertService.convertContray(originCharList);
        convertedWord = getWordFromCharList();
        return this;
    }

    public String getConvertedWord(){
        return this.convertedWord;
    }

    private ArrayList<Character> getCharListFromWord(){
        return StringListConvertService.StringToArrayList(this.originWord);
    }

    private String getWordFromCharList(){
        return StringListConvertService.ArrayListToString(this.convertedCharList);
    }
}
