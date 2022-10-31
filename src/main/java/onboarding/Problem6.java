package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<Character>> charChecker = new HashMap<>();
        initConsecutiveCharSet(charChecker, forms);
    }

    private static void initConsecutiveCharSet(Map<String, List<Character>> charChecker,
                                               List<List<String>> forms) {
        forms.forEach(item -> {

        });
    }

    private static void addStringToSet(Map<Character, List<Character>> charChecker,
                                       String name) {
        int i = 0;
        Character keyChar;
        Character nextChar;
        List<Character> valueList = new ArrayList<>();

        while (i < name.length() - 1) {
            keyChar = name.charAt(i);
            nextChar = name.charAt(i+1);

            if (charChecker.containsKey(keyChar)) {
                valueList = charChecker.get(keyChar);
                valueList.add(nextChar);
            } else {
                valueList.add(nextChar);
            }
            charChecker.put(keyChar, valueList);
            i++;
        }
    }

    // 2개씩 parsing해서 set에다 다 넣어보자.
    // 넣을때마다 교집합이 하나라도 있으면 걸린거다.
    // 제이엠, 제이슨 (제이)
    // 워니 , 워니맘 (워니)
    // {제: [이], 이: [엠, 슨], 워: {니], 엠: {제]}
}
