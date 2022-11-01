package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> nameList = getName(forms);
        List<List<String>> dubPossibilityName = checkNameDup(nameList);
        Integer[] findIndex = findIndex(dubPossibilityName, nameList).toArray(new Integer[0]);

        for(Integer i : findIndex) {
            answer.add(forms.get(i).get(0));
        }

        Collections.sort(answer);
        return answer;
    }
    public static List<String> getName(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (List<String> form : forms) {
            if (form.get(1).length() > 1) {
                list.add(form.get(1));
            }
        }
        return list;
    }
    public static List<List<String>> checkNameDup(List<String> nameList) {
        List<List<String>> getNameChar = new ArrayList<>();
        for (String s : nameList) {
            List<String> temp = new ArrayList<>();
            for (int j = 2; j <= s.length(); j++) {
                temp.add(s.substring(j - 2, j)); // endIndex 불포함
            }
            getNameChar.add(temp);
        }
        return getNameChar;
    }

    public static HashSet<Integer> findIndex(List<List<String>> dubPossibilityName,List<String> nameList) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nameList.size(); i++) {
                String nick = nameList.get(i);
                for (int k = 0; k < dubPossibilityName.size(); k++) {
                    for (String n : dubPossibilityName.get(k)) {
                        if (nick.contains(n) && i != k) {
                            set.add(i);
                        }
                    }
            }
        }
        return set;
    }
}
