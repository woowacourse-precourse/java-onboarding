package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> consecutiveTwoChar = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (int i=0; i<forms.size(); i++) {
            List<String> twoChars = getTwoCharsAfterSplit(forms.get(i).get(1));
            for (String twoChar : twoChars) {
                if (consecutiveTwoChar.containsKey(twoChar)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(consecutiveTwoChar.get(twoChar)).get(0));
                }
                consecutiveTwoChar.put(twoChar, i);
            }
        }
        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
    //리팩토링 하고 싶지만, static이라는 구조를 깨지 못해 어려울 것 같다.

    private static List<String> getTwoCharsAfterSplit(String name) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<name.length()-1; i++) {
            result.add(name.substring(i, i+2));
        }
        return result;
    }
}
