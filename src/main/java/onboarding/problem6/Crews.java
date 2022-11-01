package onboarding.problem6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Crews {
    List<Crew> crewList;

    public Crews(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public List<String> getDuplicatedCrewEmailList() {
        return crewList.stream()
                .filter(crew -> isDuplicatedCrew(crew))
                .map(crew -> crew.getEmail())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isDuplicatedCrew(Crew crew) {
        return getDuplicatedStringList().stream()
                .filter(string -> isDuplicatedCrewName(crew.getName(), string))
                .findAny()
                .isPresent();
    }

    private boolean isDuplicatedCrewName(String crewName, String string) {
        if (crewName.indexOf(string) != -1) {
            return true;
        }
        return false;
    }

    public List<String> getDuplicatedStringList() {
        return getDuplicatedStringCounts().entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getDuplicatedStringCounts() {
        Map<String, Integer> stringCount = new HashMap<>();
        for (Crew crew : crewList) {
            countSubStringInName(stringCount, crew.getName());
        }
        return stringCount;
    }

    private void countSubStringInName(Map<String, Integer> stringCount, String name) {
        for (int start = 0; start < name.length(); start++) {
            for (int end = start + 1; end < name.length(); end++) {
                putSubString(stringCount, name, start, end);
            }
        }
    }

    private void putSubString(Map<String, Integer> stringCount, String name, int start, int end) {
        stringCount.put(name.substring(start, end + 1), stringCount.getOrDefault(name.substring(start, end + 1), 0) + 1);
    }
}
