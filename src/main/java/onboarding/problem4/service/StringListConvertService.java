package onboarding.problem4.service;

import java.util.ArrayList;

public class StringListConvertService {
    public static ArrayList<Character> StringToArrayList(String word){
        ArrayList<Character> charList = new ArrayList<>();
        for(int index = 0; index<word.length(); index++){
            charList.add(word.charAt(index));
        }
        return charList;
    }
}
