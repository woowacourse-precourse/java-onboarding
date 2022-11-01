package onboarding;

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
        Map<String, Set<String>> twoSeqSubNameEmailMap = getSeqNameEmailMap(forms);
        Set<String> duplicateEmailSet = getDuplicateEmailSet(twoSeqSubNameEmailMap);

        return duplicateEmailSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    private static Map<String, Set<String>> getSeqNameEmailMap(List<List<String>> forms) {
        Map<String, Set<String>> seqNameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String name = form.get(NAME_INDEX);

            makeSequentialNameEmailMap(seqNameEmailMap, email, name);
        }
        return seqNameEmailMap;
    }

    private static void makeSequentialNameEmailMap(Map<String, Set<String>> seqNameEmailMap, String email, String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            String twoSequentialSubName = getTwoSequentialSubName(name, i);
            Set<String> emailList = seqNameEmailMap.getOrDefault(twoSequentialSubName, new HashSet<>());
            emailList.add(email);
            seqNameEmailMap.put(twoSequentialSubName, emailList);
        }
    }

    private static String getTwoSequentialSubName(String name, int i) {
        return name.substring(i, i + 2);
    }

    private static Set<String> getDuplicateEmailSet(Map<String, Set<String>> seqNameEmailMap) {
        Set<String> duplicateSet = new HashSet<>();

        seqNameEmailMap.values()
                .stream()
                .filter(emailList -> emailList.size() > 1)
                .forEach(duplicateSet::addAll);
        return duplicateSet;
    }
}