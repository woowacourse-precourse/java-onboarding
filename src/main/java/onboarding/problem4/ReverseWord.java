package onboarding.problem4;

import java.util.HashMap;
import java.util.LinkedList;

import static java.lang.String.valueOf;
import static onboarding.problem4.Dictinary.setDictionary;

public class ReverseWord {

    // 거꾸로 말하기 기능
    public static String reverseWord(String word){

        String result = "";

        HashMap<String, String> hashMap = new HashMap<>(26);
        HashMap<String, String> dictionary = setDictionary(hashMap);

        LinkedList<String> linkedList = new LinkedList<>();

        // 거꾸로 말하기
        for(int i=0; i<word.length(); i++){
            char wordIndex = word.charAt(i);
            String reverseWord = dictionary.get(valueOf(wordIndex));
            linkedList.add(reverseWord);

        }
        for (String reverseWord : linkedList) {
            result += reverseWord;
        }

        return result;
    }
}
