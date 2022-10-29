package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = fillDuplicateNameOwners(fillNameFragmentOwners(forms));

        Collections.sort(answer);
        return deduplicateInEmails(answer);
    }

    private static List<String> deduplicateInEmails(List<String> answer) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            deduplicateInEmail(answer, ret, i);
        }
        return ret;
    }

    private static void deduplicateInEmail(List<String> answer, List<String> ret, int i) {
        if (isDuplicatedEmail(answer, i)) {
            return;
        }

        ret.add(answer.get(i));
    }

    private static boolean isDuplicatedEmail(List<String> answer, int i) {
        return i != 0 && answer.get(i).equals(answer.get(i - 1));
    }

    private static List<String> fillDuplicateNameOwners(Map<String, List<String>> nameFragmentOwners) {
        List<String> ret = new ArrayList<>();
        for (List<String> owners : nameFragmentOwners.values()) {
            addDuplicateNameOwners(ret, owners);
        }
        return ret;
    }

    private static void addDuplicateNameOwners(List<String> ret, List<String> owners) {
        if (!isDuplicateNameFor(owners)) {
            return;
        }
        ret.addAll(owners);
    }

    private static boolean isDuplicateNameFor(List<String> owners) {
        return owners.size() != 1;
    }

    private static Map<String, List<String>> fillNameFragmentOwners(List<List<String>> forms) {
        Map<String, List<String>> nameFragmentOwners = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            addFragmentsOwner(nameFragmentOwners, email, nickname);
        }
        return nameFragmentOwners;
    }

    private static void addFragmentsOwner(Map<String, List<String>> nameFragmentOwners, String email, String nickname) {
        for (int j = 0; j < nickname.length() - 1; ++j) {
            addFragmentOwner(nameFragmentOwners, email, getNameFragment(nickname, j));
        }
    }

    private static void addFragmentOwner(Map<String, List<String>> nameFragmentOwners, String email,
            String nicknameFragment) {
        if (isEmptyList(nameFragmentOwners, nicknameFragment)) {
            nameFragmentOwners.put(nicknameFragment, new ArrayList<>());
        }

        nameFragmentOwners.get(nicknameFragment).add(email);
    }

    private static String getNameFragment(String nickname, int j) {
        return nickname.substring(j, j + 2);
    }

    private static boolean isEmptyList(Map<String, List<String>> nameFragmentOwners, String nicknameFragment) {
        return nameFragmentOwners.get(nicknameFragment) == null;
    }
}
