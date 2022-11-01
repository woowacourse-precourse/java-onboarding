package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = tourNicknames(forms);
        List<String> answer = organizeResult(result);

        return answer;
    }

    private static List<String> tourNicknames(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        int formSize = forms.size();

        for (int i = 0; i < formSize; ++i) {
            for (int j = 0; j < formSize; ++j) {
                if (i == j) continue;
                if (isSimilar(forms.get(i).get(1), forms.get(j).get(1))) {
                    result.add(forms.get(i).get(0));
                    result.add(forms.get(j).get(0));
                }
            }
        }
        return result;
    }

    private static boolean isSimilar(String nickname1, String nickname2) {
        int nicknameSize1 = nickname1.length();
        int nicknameSize2 = nickname2.length();

        for (int i = 0; i < nicknameSize1 - 1; ++i) {
            for (int j = 0; j < nicknameSize2 - 1; ++j) {
                if (Character.compare(nickname1.charAt(i), nickname2.charAt(j)) == 0) {
                    if (Character.compare(nickname1.charAt(i + 1), nickname2.charAt(j + 1)) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static List<String> organizeResult(List<String> str) {
        List<String> sortedList;

        str.sort(Comparator.naturalOrder());
        sortedList = str.stream().distinct().collect(Collectors.toList());

        return sortedList;
    }
}
