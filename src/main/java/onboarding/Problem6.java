package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<Character, Set<Character>> charChecker = new HashMap<>();
        initConsecutiveCharSet(charChecker, forms);
//        System.out.println(charChecker);
        List<String> a = new ArrayList<>();
        return a;
    }

    private static void initConsecutiveCharSet(Map<Character, Set<Character>> charChecker,
                                               List<List<String>> forms) {
        forms.forEach(item -> addStringToSet(charChecker, item.get(1)));
    }

    private static void addStringToSet(Map<Character, Set<Character>> charChecker,
                                       String name) {
        int i = 0;
        Character keyChar;
        Character nextChar;

        while (i < name.length() - 1) {
            keyChar = name.charAt(i);
            nextChar = name.charAt(i+1);
            Set<Character> valueSet = new HashSet<>();

            if (charChecker.containsKey(keyChar)) {
                valueSet = charChecker.get(keyChar);
                valueSet.add(nextChar);
            } else {
                valueSet.add(nextChar);
            }
            charChecker.put(keyChar, valueSet);
            i++;
        }
    }
}
// 2개씩 parsing해서 set에다 다 넣어보자.
// 넣을때마다 교집합이 하나라도 있으면 걸린거다.
// 제이엠, 제이슨 (제이)
// 워니 , 워니맘 (워니)
// {제: [이], 이: [엠, 슨], 워: {니], 엠: {제]}
