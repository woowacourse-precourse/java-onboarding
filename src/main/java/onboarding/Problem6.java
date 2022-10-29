package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> formsMap = forms.stream()
                .collect(Collectors.toMap(i -> i.get(1), i -> i.get(0)));

        List<String> names = forms.stream()
                .map(i -> i.get(1))
                .collect(Collectors.toList());

        Set<String> overlappingName = getOverlappingName(names);

        return overlappingName.stream()
                .map(formsMap::get)
                .sorted()
                .collect(Collectors.toList());
    }

    private static Set<String> getOverlappingName(List<String> names){
        Map<String, List<String>> overlappingMap = new HashMap<>();

        for (String name : names) {
            for(int i=0; i<name.length() - 1; i++) {
                String overlappingWord = name.substring(i, i+2);
                List<String> registeredNames =
                        overlappingMap.getOrDefault(overlappingWord, new ArrayList<>());
                registeredNames.add(name);

                overlappingMap.put(overlappingWord, registeredNames);
            }
        }
        overlappingMap.entrySet().stream()
                .forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));

        return overlappingMap.values().stream()
                .filter(i -> i.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}





