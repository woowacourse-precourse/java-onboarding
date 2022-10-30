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

    public static String ArrayListToString(ArrayList<Character> charList){
        StringBuilder sb = new StringBuilder(charList.size());
        for(Character character: charList){
           sb.append(character);
        }
        return sb.toString();
    }
}
