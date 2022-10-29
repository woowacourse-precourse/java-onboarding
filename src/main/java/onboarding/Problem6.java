package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );
        solution(forms);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> userNameList = createUserNameList(forms);
        String combinedNames = combineName(userNameList);
        List<String> twoLetterNames = createTwoLetterNameList(combinedNames);
        Set<String> DuplicateNameList = createDuplicateList(twoLetterNames);

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

    public static void makeWarningList(List<String> warningList, Set<String> duplicateList, List<String> form) {
        for (String s : duplicateList) {
            if (form.get(1).contains(s)) {
                warningList.add(form.get(0));
            }
        }
    }
}
