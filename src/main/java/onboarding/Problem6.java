package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, List<Integer>> ordersByDividedNickname;

    public static List<String> solution(List<List<String>> forms) {
        ordersByDividedNickname = new HashMap<>();
        for (int order = 0; order < forms.size(); order++) {
            String nickname = forms.get(order).get(1);
            saveDividedNickname(order, splitNickname(nickname));
        }
        return sortEmails(getDuplicateEmails(forms, getDuplicateCrews()));
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

    private static Set<Integer> getDuplicateCrews() {
        Set<Integer> duplicateCrews = new HashSet<>();
        for (List<Integer> orders : ordersByDividedNickname.values()) {
            if (orders.size() < 2) {
                continue;
            }
            duplicateCrews.addAll(orders);
        }
        return duplicateCrews;
    }

    private static List<String> getDuplicateEmails(List<List<String>> forms, Set<Integer> duplicateCrews) {
        List<String> duplicateEmails = new ArrayList<>();
        for (int order : duplicateCrews) {
            duplicateEmails.add(forms.get(order).get(0));
        }
        return duplicateEmails;
    }

    private static List<String> sortEmails(List<String> duplicateEmails) {
        Collections.sort(duplicateEmails);
        return duplicateEmails;
    }
}
