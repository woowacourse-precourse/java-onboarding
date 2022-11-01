package onboarding;


import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<Integer> dupIndSet = new HashSet<>();
        solution1(forms, dupIndSet);
        List<String> duplicateEmails = new ArrayList<>();

        Iterator<Integer> it = dupIndSet.iterator();

        while (it.hasNext()) {
            duplicateEmails.add(forms.get(it.next()).get(0));
        }

        Collections.sort(duplicateEmails);
        return duplicateEmails;
    }

    public static void solution1(List<List<String>> forms, Set<Integer> duplicateIndexSet) {
        Map<String, Integer> subnameIndMap = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {

            String name = forms.get(i).get(1);

            for (int j = 0; j < name.length() - 1; j++) {

                String subname = name.substring(j, j + 2);

                if (subnameIndMap.containsKey(subname)) {
                    duplicateIndexSet.add(subnameIndMap.get(subname));
                    duplicateIndexSet.add(i);
                } else {
                    subnameIndMap.put(subname, i);
                }
            }
        }
    }
}