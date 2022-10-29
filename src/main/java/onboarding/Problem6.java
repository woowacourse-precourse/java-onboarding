package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> nameFragmentOwners = fillNameFragmentOwners(forms);

        for (List<String> owners : nameFragmentOwners.values()) {
            if (owners.size() == 1) {
                continue;
            }
            answer.addAll(owners);
        }

        Collections.sort(answer);

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            if (i != 0 && answer.get(i).equals(answer.get(i - 1))) {
                continue;
            }

            ret.add(answer.get(i));
        }

        return ret;
    }

    private static Map<String, List<String>> fillNameFragmentOwners(List<List<String>> forms) {
        Map<String, List<String>> nameFragmentOwners = new HashMap<>();

        for (int i = 0; i < forms.size(); ++i) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

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
        String nicknameFragment = nickname.substring(j, j + 2);
        return nicknameFragment;
    }

    private static boolean isEmptyList(Map<String, List<String>> nameFragmentOwners, String nicknameFragment) {
        return nameFragmentOwners.get(nicknameFragment) == null;
    }
}
