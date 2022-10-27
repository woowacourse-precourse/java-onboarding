package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static final int MAX_CREW_COUNT = 10000;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(MAX_CREW_COUNT);

        for (int i = 0; i < forms.size() - 1; ++i) {
            String baseEmail = forms.get(i).get(0);
            String baseNickName = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); ++j) {
                String compareEmail = forms.get(j).get(0);
                String compareNickName = forms.get(j).get(1);

                if (isRestrictedNickName(baseNickName, compareNickName)) {
                    if (!answer.contains(compareEmail)) {
                        answer.add(compareEmail);
                    }

                    if (!answer.contains(baseEmail)) {
                        answer.add(baseEmail);
                    }
                }
            }

        }

        return answer;
    }

    private static boolean isRestrictedNickName(String baseNickname, String compareNickName) {
        for (int i = 0; i < compareNickName.length() - 1; ++i) {
            String checkNickName = compareNickName.substring(i, i + 2);
            if (baseNickname.contains(checkNickName)) {
                return true;
            }
        }

        return false;
    }
}
