package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        answer = execute(forms);
        return answer;
    }

    /**
     * 입력받은 닉네임 목록 중 일부 단어가 중복된 닉네임을 확인한다.
     * 
     * @param forms
     * @return
     */
    private static List<String> execute(List<List<String>> forms) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++) {
            boolean isLimit = false;
            for (int j = 0; j < forms.size(); j++) {
                // 같은 인덱스는 SKIP 한다.
                if (i == j)
                    continue;

                isLimit = isContain(forms.get(i).get(1), forms.get(j).get(1));
                if (isLimit) {
                    // 중복 닉네임이 존재하면 제한닉넴 목록에 포함하고, 반복문에서 빠져 나온다.
                    result.add(forms.get(i).get(0));
                    break;
                }
            }
        }

        // 오름차순으로 정렬
        result.sort(Comparator.naturalOrder());
        return result;
    }

    /**
     * 원본 별명의 연속된 두글자가 비교 별명에 포함되어 있는지 확인한다.
     * 
     * @param nickname1 원본 별명
     * @param nickname2 비교 별명
     * @return
     */
    private static boolean isContain(String nickname1, String nickname2) {
        // 별명의 마지막글자는 한글자 뿐이므로 수행하지 않는다.
        for (int i = 0; i < nickname1.length() - 1; i++) {
            // 원본 별명에서 두글자를 자른 후 비교 별명에서 같은 글자가 있는지 확인 한다.
            int index = nickname2.indexOf(nickname1.substring(i, i + 2));
            if (index != -1) {
                return true;
            }
        }
        return false;
    }
}
