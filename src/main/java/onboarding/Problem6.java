package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> twoNameList = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(List<String> form : forms) {
            List<String> twoWords = myTwoNames(form.get(1));
            for (String word : twoWords) {
                if (twoNameList.containsKey(word)) {
                    twoNameList.put(word, twoNameList.get(word)+1);
                } else {
                    twoNameList.put(word, 1);
                }
            }
        }
        for (List<String> form : forms) {
            for (String word : myTwoNames(form.get(1))) {
                if (twoNameList.get(word) > 1) {
                    answer.add(form.get(0));
                    break;
                }
            }
        }


        return answer;
    }

    private static List<String> myTwoNames(String name) {
        List<String> twoNames = new ArrayList<>();
        for (int idx = 0 ; idx < name.length()-1 ; idx++) {
            twoNames.add(name.substring(idx, idx+2));
        }
        return twoNames;
    }

}
