package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> userNameList = createUserNameList(forms);
        String combinedNames = combineName(userNameList);
        List<String> twoLetterNames = createTwoLetterNameList(combinedNames);


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

    public static List<String> createTwoLetterNameList(String name) {
        List<String> nameList = new ArrayList<>();
        String[] str = name.split("");
        for (int i = 0; i < str.length - 2; i++) {
            nameList.add(str[i] + str[i+1]);
        }
        return nameList.stream().filter(i -> !i.contains(",")).collect(Collectors.toList());
    }


    public static void makeWarningList(List<String> warningList, Set<String> duplicateList, List<String> form) {
        for (String s : duplicateList) {
            if (form.get(1).contains(s)) {
                warningList.add(form.get(0));
            }
        }
    }
}
