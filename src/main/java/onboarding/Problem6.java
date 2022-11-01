package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static HashMap<String, List<Integer>> ordersByDividedNickname;

    public static List<String> solution(List<List<String>> forms) {
        ordersByDividedNickname = new HashMap<>();
        for (int order = 0; order < forms.size(); order++) {
            String nickname = forms.get(order).get(1);
            saveDividedNickname(order, splitNickname(nickname));
        }
        return distinctAndSortEmails(getDuplicateEmails(forms, getDuplicateCrewOrders()));
    }

    private static List<String> splitNickname(String nickname) {
        List<String> dividedNicknames = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            dividedNicknames.add(nickname.substring(i, i + 2));
        }
        return dividedNicknames;
    }

    private static void saveDividedNickname(int order, List<String> dividedNicknames) {
        for (String dividedNickname : dividedNicknames) {
            ordersByDividedNickname.putIfAbsent(dividedNickname, new ArrayList<>());
            ordersByDividedNickname.get(dividedNickname).add(order);
        }
    }

    private static List<Integer> getDuplicateCrewOrders() {
        return ordersByDividedNickname.values().stream()
                .filter(o -> o.size() >= 2)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> getDuplicateEmails(List<List<String>> forms, List<Integer> duplicateCrewOrders) {
        List<String> duplicateEmails = new ArrayList<>();
        for (int order : duplicateCrewOrders) {
            duplicateEmails.add(forms.get(order).get(0));
        }
        return duplicateEmails;
    }

    private static List<String> distinctAndSortEmails(List<String> duplicateEmails) {
        return duplicateEmails.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
