package onboarding.problem4.controller;

import onboarding.problem4.service.AlphabetConvertService;
import onboarding.problem4.service.StringListConvertService;
import java.util.ArrayList;

public class AlphabetContrayConvertor {
    private String originWord;
    private String convertedWord;
    private ArrayList<Character> originCharList;
    private ArrayList<Character> convertedCharList;

    public AlphabetContrayConvertor setWord(String word){
        this.originWord = word;
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
