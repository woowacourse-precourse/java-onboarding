package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static final Map<String, String> crewInfoMap = new HashMap<>();

    public static List<String> solution(List<List<String>> crewInfoForms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void initCrewInfoMap(List<List<String>> crewForms) {
        crewForms.stream()
                .forEach(crewInfo -> {
                    String crewNickname = crewInfo.get(1);
                    String crewEmail = crewInfo.get(0);
                    crewInfoMap.put(crewNickname, crewEmail);
                });
    }

    private static List<String> excludeLengthOneCrewNickname() {
        List<String> duplicableCrewNicknames = crewInfoMap.keySet().stream()
                .filter(crewNickname -> crewNickname.length() != 1)
                .collect(Collectors.toList());
        return duplicableCrewNicknames;
    }

    private static List<String> getSubstringCrewNicknames(List<String> duplicableCrewNicknames) {
        List<String> substringCrewNicknames = new ArrayList<>();
        duplicableCrewNicknames.forEach(
                duplicableCrewNickname -> {
                    for (int subStringIndex = 0; subStringIndex < duplicableCrewNickname.length() - 1; subStringIndex++) {
                        substringCrewNicknames.add(duplicableCrewNickname.substring(subStringIndex, subStringIndex + 2));
                    }
                }
        );
        return substringCrewNicknames;
    }

    private static Set<String> extractDuplicateSubstringCrewNicknames(List<String> substringCrewNicknames) {
        Set<String> DuplicateSubstringCrewNicknames = substringCrewNicknames.stream()
                .filter(substringCrewNickname ->
                        substringCrewNicknames.indexOf(substringCrewNickname) !=
                                substringCrewNicknames.lastIndexOf(substringCrewNickname))
                .collect(Collectors.toSet());
        return DuplicateSubstringCrewNicknames;
    }

    private static List<String> getDuplicateCrewNicknames(List<String> duplicableCrewNicknames, Set<String> DuplicateSubstringCrewNicknames) {
        List<String> duplicateCrewNicknames = new ArrayList<>();
        duplicableCrewNicknames.forEach(duplicableCrewNickname -> {
            DuplicateSubstringCrewNicknames.forEach(
                    duplicateSubstringCrewNickname -> {
                        if(duplicableCrewNickname.contains(duplicateSubstringCrewNickname)) {
                            duplicateCrewNicknames.add(duplicableCrewNickname);
                        }
                    }
            );
        });
        return duplicateCrewNicknames;
    }

}
