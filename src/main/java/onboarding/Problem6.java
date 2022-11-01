package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> email = new ArrayList<>(forms.size());
        List<String> name = new ArrayList<>(forms.size());

        // 이름과 이메일 나눠서 저장
        for (int i = 0; i < forms.size(); i++) {
            email.add(i, forms.get(i).get(0));
            name.add(i, forms.get(i).get(1));
        }

        // 중복된 닉네임인지 판별
        boolean[] isChecked = new boolean[forms.size()];
        for (int i = 0; i < name.size(); i++) {
            if (isChecked[i]) {
                continue;
            }

            for (int j = 0; j < name.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (hasOverlap(name.get(i), name.get(j))) {
                    answer.add(email.get(i));
                    answer.add(email.get(j));
                    isChecked[j] = true;
                    break;
                }
            }
        }

        Set<String> answerSet = new HashSet<>(answer);
        answer = new ArrayList<>(answerSet);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    static boolean hasOverlap(String str, String other) {
        for (int i = 0; i < str.length()-1; i++) {
            String unit = str.substring(i, i+2);
            if (other.contains(unit)) {
                return true;
            }
        }
        return false;
    }
}
