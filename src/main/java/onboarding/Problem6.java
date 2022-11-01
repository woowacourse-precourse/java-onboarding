package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = new Crews(forms.stream()
                .map(form -> new Crew(form.get(0), form.get(1)))
                .collect(Collectors.toList()));
        return getDuplicatedCrewEmailList(forms, getDuplicatedStringList(getDuplicatedStringCounts(forms)));
    }

    public static Map<String, Integer> getDuplicatedStringCounts(List<List<String>> forms) {
        Map<String, Integer> stringCount = new HashMap<>();
        for (List<String> crew : forms) {
            countSubStringInName(stringCount, crew.get(1));
        }
        return stringCount;
    }

    private static void countSubStringInName(Map<String, Integer> stringCount, String name) {
        for (int start = 0; start < name.length(); start++) {
            for (int end = start + 1; end < name.length(); end++) {
                putSubString(stringCount, name, start, end);
            }
        }
    }

    private static void putSubString(Map<String, Integer> stringCount, String name, int start, int end) {
        stringCount.put(name.substring(start, end + 1), stringCount.getOrDefault(name.substring(start, end + 1), 0) + 1);
    }

    public static List<String> getDuplicatedStringList(Map<String, Integer> stringCount) {
        return stringCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public static List<String> getDuplicatedCrewEmailList(List<List<String>> forms, List<String> duplicatedStringList) {
        return forms.stream()
                .filter(form -> isDuplicatedCrew(form, duplicatedStringList))
                .map(form -> form.get(0))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isDuplicatedCrew(List<String> crew, List<String> duplicatedStringList) {
        return duplicatedStringList.stream()
                .filter(string -> isDuplicatedCrewName(crew.get(1), string))
                .findAny()
                .isPresent();
    }

    private static boolean isDuplicatedCrewName(String crewName, String string) {
        if (crewName.indexOf(string) != -1) {
            return true;
        }
        return false;
    }
}
