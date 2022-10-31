package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    private static final int MAX_CREW_COUNT = 10000;

    private static final String EMAIL_DELIMITER = "@";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(MAX_CREW_COUNT);

        for (int i = 0; i < forms.size() - 1; ++i) {
            String baseEmail = forms.get(i).get(0);
            String baseNickName = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); ++j) {
                String compareEmail = forms.get(j).get(0);
                String compareNickName = forms.get(j).get(1);

                if (isRestrictedNickName(baseNickName, compareNickName)) {
                    if (!answer.contains(baseEmail)) {
                        answer.add(baseEmail);
                    }

                    if (!answer.contains(compareEmail)) {
                        answer.add(compareEmail);
                    }
                }
            }
        }

        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Split = s1.split(EMAIL_DELIMITER);
                String[] s2Split = s2.split(EMAIL_DELIMITER);
                return s1Split[0].compareToIgnoreCase(s2Split[0]);
            }
        });

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
