package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> infoMap = parseUserInfo(forms);

        Set<String> duplicatedEmailSet = findDuplicatedNames(infoMap);

        List<String> duplicatedEmailList = new ArrayList<>(duplicatedEmailSet);

        Collections.sort(duplicatedEmailList);

        return duplicatedEmailList;
    }

    private static Set<String> findDuplicatedNames(HashMap<String, String> infoMap) {
        Set<String> duplicated = new HashSet<>();
        List<String> names = new ArrayList<>(infoMap.keySet());

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            boolean isDuplicate = false;

            if (name.length() < 2) continue;

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);

                for (int k = i+1; k < names.size(); k++) {
                    String compare = names.get(k);

                    if (compare.contains(key)) {
                        isDuplicate = true;
                        duplicated.add(infoMap.get(compare));
                    }
                }

                if (isDuplicate) duplicated.add(infoMap.get(name));
            }
        }

        return duplicated;
    }

    private static HashMap<String, String> parseUserInfo(List<List<String>> forms) {
        HashMap<String, String> result = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);

            String email = form.get(0);
            String name = form.get(1);

            if (!validate(email)) continue;

            if (!result.containsKey(name)) {
                result.put(name, email);
            }
            else {
                result.put(name + i, email);
            }
        }

        return new HashMap<>(result);
    }

    private static boolean validate(String email) {
        if (!email.substring(email.length()-9).equals("email.com")) return false;
        return true;
    }
}
