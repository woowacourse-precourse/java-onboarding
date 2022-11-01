package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nameList = makeNameList(forms);
        List<String> allCaseName = getAllCaseName(nameList);
        List<List<Integer>> caseIndexList = checkSame(nameList, allCaseName);
        List<Integer> sameIndexList = getSameNameIndexList(caseIndexList);
        List<String> answer = getEmailList(forms, sameIndexList);
        Collections.sort(answer);
        return answer;
    }

    private static List<String> getEmailList(List<List<String>> forms, List<Integer> sameIndexList) {
        List<String> emailList = new ArrayList<>();

        for (int index : sameIndexList) {
            emailList.add(forms.get(index).get(0));
        }
        return emailList;
    }

    private static List<Integer> getSameNameIndexList(List<List<Integer>> caseIndexList) {
        HashSet<Integer> nameIndexSet = new HashSet<>();

        for (List<Integer> caseIndex : caseIndexList) {

            if (caseIndex.size() > 1) {
                nameIndexSet.addAll(caseIndex);
            }
        }
        return new ArrayList<>(nameIndexSet);
    }

    private static List<List<Integer>> checkSame(List<String> nameList, List<String> nameCaseList) {
        List<List<Integer>> index = new ArrayList<>();

        for (String nameCase : nameCaseList) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < nameList.size(); j++) {
                if (nameList.get(j).contains(nameCase)) {
                    tmpList.add(j);
                }
            }
            index.add(tmpList);
        }
        return index;
    }

    private static List<String> getAllCaseName(List<String> nameList) {
        HashSet<String> allCaseSet = new HashSet<>();

        for (String name : nameList) {
            for (int j = 0; j <= name.length() - 2; j++) {
                allCaseSet.add(name.substring(j, j + 2));
            }
        }
        return new ArrayList<>(allCaseSet);
    }

    static List<String> makeNameList(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (List<String> list : forms) {
            nameList.add(list.get(1));
        }
        return nameList;
    }
}
