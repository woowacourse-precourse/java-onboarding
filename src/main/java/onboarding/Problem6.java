package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nameList = makeNameList(forms);
        List<List<String>> nameTemp = makeTempList(nameList);
        Integer[] findIndexArr = findIndex(nameTemp).toArray(new Integer[findIndex(nameTemp).size()]);

        for (Integer integer : findIndexArr) {
            answer.add(forms.get(integer).get(0));
        }

        Collections.sort(answer);


        return answer;
    }

    static List<String> makeNameList(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).length() > 1) {
                list.add(forms.get(i).get(1));
            }
        }
        return list;
    }

    static List<List<String>> makeTempList(List<String> nameList) {
        List<List<String>> nameTemp = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 2; j <= nameList.get(i).length(); j++) {
                tempList.add(nameList.get(i).substring(j - 2, j));
            }
            nameTemp.add(tempList);
        }
        return nameTemp;
    }

    static HashSet<Integer> findIndex(List<List<String>> nameTemp) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nameTemp.size(); i++) {
            for (int j = 0; j < nameTemp.get(i).size(); j++) {
                if (nameTemp.get(j).contains(nameTemp.get(i).get(j))) {
                    set.add(i);
                }
            }
        }
        return set;
    }
}