package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> treeSet = new TreeSet<>();
        Map<String, String> hashMap = new HashMap<>();

        for (List<String> form: forms) {
            addEmailByDuplicateName(form, treeSet, hashMap);
        }

        return new ArrayList<>(treeSet);
    }


    private static void addEmailByDuplicateName(List<String> form, Set<String> treeSet, Map<String, String> hashMap) {
        String email = form.get(0);
        String name = form.get(1);

        for (int i = 1; i < name.length(); i++) {
            String subName = name.substring(i-1, i+1);

            if (!hashMap.containsKey(subName)) {
                hashMap.put(subName, email);
                continue;
            }

            treeSet.add(email);
            treeSet.add(hashMap.get(subName));
        }
    }
}
