package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> DuplicateNameList = new HashSet<>();
        List<String> answer = new ArrayList<>();

        List<String> userNameList = createUserNameList(forms);
        String combinedNames = combineName(userNameList);
        for (Map.Entry<String, Integer> entry : userTwoLetterList.entrySet()) {
            makeDuplicateNameList(DuplicateNameList, entry);
        }
        for (List<String> form : forms) {
            makeWarningList(answer, DuplicateNameList, form);
        }
        Collections.sort(answer);
        return answer;
    }

    public static List<String> createUserNameList(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (List<String> form : forms) {
            nameList.add(form.get(1));
        }
        return nameList;
    }

    public static String combineName(List<String> nameList) {
        StringBuilder joinName = new StringBuilder();
        for (String s : nameList) {
            joinName.append(s).append(",");
        }
        return joinName.toString();
    }

    public static void makeDuplicateNameList(Set<String> duplicateList, Map.Entry<String, Integer> entry) {
        if (entry.getValue() > 1) {
            duplicateList.add(entry.getKey());
        }
    }
    public static void makeWarningList(List<String> warningList, Set<String> duplicateList, List<String> form) {
        for (String s : duplicateList) {
            if (form.get(1).contains(s)) {
                warningList.add(form.get(0));
            }
        }
    }
}
