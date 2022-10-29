package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> nameFragmentOwners = new HashMap<>();

        for (int i = 0; i < forms.size(); ++i) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; ++j) {
                String nicknameFragment = nickname.substring(j, j + 2);

                if (nameFragmentOwners.get(nicknameFragment) == null) {
                    nameFragmentOwners.put(nicknameFragment, new ArrayList<>());
                }

                nameFragmentOwners.get(nicknameFragment).add(email);
            }
        }

        for (List<String> owners : nameFragmentOwners.values()) {
            if (owners.size() == 1) {
                continue;
            }
            answer.addAll(owners);
        }

        Collections.sort(answer);

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            if (i != 0 && answer.get(i).equals(answer.get(i-1))) {
                continue;
            }

            ret.add(answer.get(i));
        }

        return ret;
    }
}
