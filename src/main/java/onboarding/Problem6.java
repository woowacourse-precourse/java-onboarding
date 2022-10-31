package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crewInfo = new HashMap<>();
        List<String> answer = new ArrayList<>();

        forms.forEach(form ->
                crewInfo.put(form.get(1), form.get(0))
        );

        return answer;
    }

    private static List<String> getDuplicateNickNames(List<String> nameList, String name) {
        List<String> duplicateNickNameList = getOtherDuplicateNickNames(nameList, name);
        if (!duplicateNickNameList.isEmpty()) {
            duplicateNickNameList.add(name);
        }
        return duplicateNickNameList;
    }

    private static List<String> getOtherDuplicateNickNames(List<String> nameList, String name) {
        int index = 0;
        int count = 2;
        List<String> duplicateNickNameList = new ArrayList<>();
        while (index + count <= name.length()) {
            String subName = name.substring(index, index + count);
            for (String otherName : nameList) {
                if (otherName.equals(name))
                    continue;
                if (otherName.contains(subName))
                    duplicateNickNameList.add(otherName);
            }
            index += 1;
            count += 1;
        }
        return duplicateNickNameList;
    }

}
