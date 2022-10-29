package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedCrewNameList(forms);
    }

    private static List<String> getDuplicatedCrewNameList(List<List<String>> forms) {
        HashSet<String> duplicationCrewNameSet = new HashSet<>();
        int skip = 1;
        for (List<String> form : forms) {
            List<String> parseNameList = getParseNameList(form);
            List<String> collect = forms.stream()
                                        .skip(skip++)
                                        .filter(crews -> hasMatchingSubstring(crews.get(1),parseNameList))
                                        .map(crews -> crews.get(0))
                                        .collect(Collectors.toList());
            if (collect.size() > 0) {
                //중복된 크루이름이 있으면 비교크루 이메일을 set 에 추가
                duplicationCrewNameSet.add(forms.get(skip-2).get(0));
                duplicationCrewNameSet.addAll(collect);
            }
        }
        ArrayList<String> duplicatedCrewNameList = new ArrayList<>(duplicationCrewNameSet);
        duplicatedCrewNameList.sort(Comparator.naturalOrder());

        return duplicatedCrewNameList;
    }
    private static boolean hasMatchingSubstring(String str, List<String> substrings) {
        return substrings.stream()
                         .anyMatch(str::contains);
    }

    private static List<String> getParseNameList(List<String> crews) {
        String crewName = crews.get(1);
        List<String> parseNameList = new ArrayList<>();
        for (int i = 0; i < crewName.length() -1; i++) {
            parseNameList.add(crewName.substring(i, i + 2));
        }
        return parseNameList;
    }
}
