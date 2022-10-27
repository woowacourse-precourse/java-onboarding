package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.sort;

public class Problem6 {

    /**
     *
     * @param name1 (닉네임 1)
     * @param name2 (닉네임 2)
     * @return 두 닉네임에 중복이 존재하는지 여부를 boolean으로 반환
     */
    public static boolean isDuplicate(String name1, String name2) {

        Set<String> name2Word = new HashSet<>();
        // 닉네임2에서 나올 수 있는 길이 2의 모든 substring을 set에 저장
        for (int i = 0; i < name2.length() - 1 ; i++) {
            name2Word.add(name2.substring(i, i + 2));
        }

        // 닉네임1에서 나올 수 있는 길이 2의 모든 substring을 계산하면서, 해당 substring이 name2에서 나온 것과 중복되는지 검사
        for (int i = 0; i < name1.length() - 1; i++) {
            String target = name1.substring(i, i + 2);

            for (String word : name2Word) {
                if (target.equals(word)) return true;
            }
        }

        return false;
    }

    public static List<String> solution(List<List<String>> forms) {

        Set<String> emailSet = new HashSet<>();

        // 모든 쌍끼리 닉네임 비교를 하고, 닉네임에 중복이 존재할 경우, 이메일을 set에 저장
        for (int i = 0; i < forms.size(); i++) {
            String name1 = forms.get(i).get(1);
            for (int j = i + 1; j < forms.size(); j++) {
                String name2 = forms.get(j).get(1);

                if (isDuplicate(name1, name2)) {
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }

        // set을 List로 형변환 후, 정렬
        List<String> answer = new ArrayList<>(emailSet);
        sort(answer);

        return answer;
    }
}
