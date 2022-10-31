package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        Map<String, String> frogDict = makeFrogDictionary();

        List<String> charList = new ArrayList<>(List.of(word.split("")));

        List<String> newCharList = convertWithFrogDict(charList, frogDict);

        return answer;
    }

    private static Map<String, String> makeFrogDictionary() {
        Map<String, String> frogDict = new HashMap<String, String>();
        List<String> keys = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        List<String> values = List.of("Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A");
        for(int i = 0; i < keys.size(); i++) {
            frogDict.put(keys.get(i), values.get(i));
            frogDict.put(keys.get(i).toLowerCase(), values.get(i).toLowerCase());
        }
        return frogDict;
    }

    private static List<String> convertWithFrogDict(List<String> charList, Map<String,String> frogDict) {
        List<String> result = new ArrayList<>();
        for (String letter : charList) {
            String convertedLetter = frogDict.getOrDefault(letter, letter);
            result.add(convertedLetter);
        }
        return result;
    }
}
