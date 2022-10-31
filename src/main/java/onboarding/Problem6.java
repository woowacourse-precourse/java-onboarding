package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    public static final int EMAIL_INDEX = 0;
    public static final int NAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> seqNameEmailMap = getSeqNameEmailMap(forms);
        Set<String> duplicateEmailSet = getDuplicateEmailSet(seqNameEmailMap);

        return duplicateEmailSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    private static Map<String, List<String>> getSeqNameEmailMap(List<List<String>> forms) {
        Map<String, List<String>> seqNameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String name = form.get(NAME_INDEX);

            makeSequentialNameEmailMap(seqNameEmailMap, email, name);
        }
        return seqNameEmailMap;
    }

    private static void makeSequentialNameEmailMap(Map<String, List<String>> seqNameEmailMap, String email, String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            String sequence = name.substring(i, i + 2);
            List<String> emailList = seqNameEmailMap.getOrDefault(sequence, new ArrayList<>());
            emailList.add(email);
            seqNameEmailMap.put(sequence, emailList);
        }
    }

    private static Set<String> getDuplicateEmailSet(Map<String, List<String>> seqNameEmailMap) {
        Set<String> duplicateSet = new HashSet<>();

        seqNameEmailMap.values()
                .stream()
                .filter(emailList -> emailList.size() > 1)
                .forEach(duplicateSet::addAll);
        return duplicateSet;
    }
}
