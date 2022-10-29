package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> userNameList = createUserNameList(forms);
        String combinedNames = combineName(userNameList);
        List<String> twoLetterNames = createTwoLetterNameList(combinedNames);
        Set<String> DuplicateNameList = createDuplicateList(twoLetterNames);
        List<String> answer = createWarningList(DuplicateNameList, forms);
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

    public static List<String> createTwoLetterNameList(String name) {
        List<String> nameList = new ArrayList<>();
        String[] str = name.split("");
        for (int i = 0; i < str.length - 2; i++) {
            nameList.add(str[i] + str[i+1]);
        }
        return nameList.stream().filter(i -> !i.contains(",")).sorted().collect(Collectors.toList());
    }

    public static Set<String> createDuplicateList(List<String> nameList) {
        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < nameList.size()-1; i++) {
            addDuplicateName(nameSet, nameList.get(i), nameList.get(i+1));
        }
        return nameSet;
    }

    public static void addDuplicateName(Set<String> nameSet, String name1, String name2) {
        if (name1.equals(name2)) {
            nameSet.add(name1);
        }
    }

    public static List<String> createWarningList(Set<String> nameSet, List<List<String>> forms) {
        List<String> warningNames = new ArrayList<>();
        for (List<String> form : forms) {
            getWarningListByNameSet(nameSet, form, warningNames);
        }
        return warningNames;
    }

    public static void getWarningListByNameSet(Set<String> nameSet, List<String> userInfo, List<String> nameList) {
        for (String s : nameSet) {
            addWarningName(s, userInfo, nameList);
        }
    }

    public static void addWarningName(String name, List<String> userInfo, List<String> nameList) {
        if (userInfo.get(1).contains(name)) {
            nameList.add(userInfo.get(0));
        }
    }
}
