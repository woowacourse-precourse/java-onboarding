package onboarding.problem2.service;

import java.util.ArrayList;

public class RemoveCharService {
    public static String removeWordFromRange(String word, ArrayList<int[]> removeRange){
        ArrayList<String> removeWordList = getWordListFromRange(word, removeRange);
        String resultWord = removeWord(word, removeWordList);
        return word;
    }

    private static String removeWord(String word, ArrayList<String> removeWordList){
        for(String removeWord : removeWordList){
            word = String.join("", word.split(removeWord));
        }
        return word;
    }
    //문자의 위치를 받고, 해당 문자열을 ArrayList 에 담아서 반환한다.
    private static ArrayList<String> getWordListFromRange(String string, ArrayList<int[]> rangeList){
        ArrayList<String> consecutiveWordArray = new ArrayList<String>();
        for(int [] removeRange : rangeList){
            String removeWord = getWordFromRange(string, removeRange);
            consecutiveWordArray.add(removeWord);
        }

        return consecutiveWordArray;
    }

    private static String getWordFromRange(String string, int[] range){
        return string.substring(range[0], (range[1]+1));
    }
}
