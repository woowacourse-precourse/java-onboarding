package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    public static boolean isDuplicated(String first, String second) throws StringIndexOutOfBoundsException{
        if (first.equals(second)) {
            return true;
        } else {
//             what to do
            for (int i = 0; i < first.length() - 1; i++) {
                for (int j = 0; j < second.length(); j++) {
                    if (first.charAt(i) == second.charAt(j)) {
                        if (first.charAt(i + 1) == second.charAt(j + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String email;
        String nickname;
        int i, j;

        for (i = 0; i < forms.size() - 1; i++) {
            for (j = i + 1; j < forms.size(); j++) {
                List<String> first = forms.get(i);
                List<String> second = forms.get(j);

                try {
                    if (isDuplicated(first.get(1), second.get(1))) {
                        answer.add(first.get(0));
                        answer.add(second.get(0));
                    }
                }catch (StringIndexOutOfBoundsException e) {}
            }
        }

        answer = new ArrayList<>(new HashSet<>(answer)); // 중복 제거
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
