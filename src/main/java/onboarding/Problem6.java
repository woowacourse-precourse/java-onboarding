package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, Integer> twoLetterHashMap = new HashMap<>();

        for (List<String> form : forms) {
            twoLetterHashMap = putTwoLetters(form, twoLetterHashMap);
        }

        return answer;
    }

    public static HashMap<String, Integer> putTwoLetters(List<String> form, HashMap<String, Integer> twoLetterHashMap) {
        String targetNickname = form.get(NICKNAME);

        for (int i = 0; i < targetNickname.length() - 1; i++) {
            String twoLetter = targetNickname.substring(i, i + 2);
            twoLetterHashMap.put(twoLetter, twoLetterHashMap.getOrDefault(twoLetter, 0) + 1);
        }

        return twoLetterHashMap;
    }
}
