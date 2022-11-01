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

        return toSortedList(duplicateEmailSet);
    }

    private static List<String> toSortedList(Set<String> duplicateEmailSet) {
        return duplicateEmailSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Map<String, Set<String>> getSeqNameEmailMap(List<List<String>> forms) {
        Map<String, Set<String>> seqSubNameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String name = form.get(NAME_INDEX);

            Set<String> twoSequentialSubNameSet = getTwoSequentialSubNameSet(name);
            twoSequentialSubNameSet
                    .forEach(twoSeqSubName -> addEmail(seqSubNameEmailMap, email, twoSeqSubName));
        }
        return seqSubNameEmailMap;
    }

    private static Set<String> getTwoSequentialSubNameSet(String name) {
        Set<String> twoSequentialSubNameList = new HashSet<>();
        for (int i = 0; i < name.length() - 1; i++) {
            String twoSequentialSubName = getTwoSequentialSubName(name, i);
            twoSequentialSubNameList.add(twoSequentialSubName);
        }
        return twoSequentialSubNameList;
    }

    private static void addEmail(Map<String, Set<String>> seqSubNameEmailMap, String email, String twoSeqSubName) {
        Set<String> emailSet = seqSubNameEmailMap.getOrDefault(twoSeqSubName, new HashSet<>());
        emailSet.add(email);
        seqSubNameEmailMap.put(twoSeqSubName, emailSet);
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