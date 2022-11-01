package onboarding;

import java.util.*;
class CompareName {
    List<String> splittedNames = new ArrayList<>();

    CompareName(List<List<String>> nameList) {
        String currentName = "";
        for (int nameIndex = 0; nameIndex < nameList.size(); nameIndex++) {
            currentName = nameList.get(nameIndex).get(1);
            for (int subStringIndex = 0; subStringIndex < currentName.length() - 1; subStringIndex++) {
                this.splittedNames.add(currentName.substring(subStringIndex, subStringIndex + 2));
            }
        }
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
