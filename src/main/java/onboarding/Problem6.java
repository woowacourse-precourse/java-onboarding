package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> duplicatedStringCountMap = generateDuplicatedNamesMap(forms);

        List<String> duplicatedStrings = generateCompareNames(duplicatedStringCountMap);

        List<String> results = generateResults(forms, duplicatedStrings);
        Collections.sort(results);

        return results;
    }

    private static Map<String, Integer> generateDuplicatedNamesMap(List<List<String>> forms) {
        Map<String, Integer> duplicatedNamesMap = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length()-1; i++) {
                String substring = name.substring(i, i + 2);
                duplicatedNamesMap.merge(substring, 1, (oldValue, newValue) -> oldValue + 1);
            }
        }
        return duplicatedNamesMap;
    }

    private static List<String> generateCompareNames(Map<String, Integer> duplicatedNamesMap) {
        List<String> compareNames = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : duplicatedNamesMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > 1) {
                compareNames.add(key);
            }
        }

        return compareNames;
    }

    private static List<String> generateResults(List<List<String>> forms, List<String> compareNames) {
        List<String> results = new ArrayList<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            for (String compareName : compareNames) {
                if (containName(name, compareName)) {
                    results.add(form.get(0));
                }
            }
        }
        return results;
    }

    private static boolean containName(String name, String compareName) {
        for (int i = 0; i < name.length() - 1; i++) {
            String substring = name.substring(i, i + 2);
            if (substring.equals(compareName)) {
                return true;
            }
        }
        return false;
    }

}
