package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedCrewName(forms);
    }

    private static List<String> getDuplicatedCrewName(List<List<String>> forms) {
        HashSet<String> duplicationCrewNameSet = new HashSet<>();
        int skip = 1;
        for (List<String> form : forms) {
            List<String> parseNameList = getParseNameList(form);
            List<String> collect = forms.stream()
                                        .skip(skip++)
                                        .filter(crews -> hasMatchingSubstring(crews.get(1),parseNameList))
                                        .map(crews -> crews.get(0))
                                        .collect(Collectors.toList());
            duplicationCrewNameSet.addAll(collect);

        }
        return new ArrayList<>(duplicationCrewNameSet);
    }
    private static boolean hasMatchingSubstring(String str, List<String> substrings) {
        return substrings.stream().anyMatch(str::contains);
    }

    private static List<String> getParseNameList(List<String> crews) {
        String crewName = crews.get(1);
        List<String> parseNameList = new ArrayList<>();
        for (int i = 0; i < crewName.length() -1; i++) {
            parseNameList.add(crewName.substring(i, i + 1));
        }
        return parseNameList;
    }
}
