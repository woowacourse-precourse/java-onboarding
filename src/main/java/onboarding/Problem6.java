package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        /* ArrayList를 이용하여 2자리 이상 단어 담기 */
        List<String> ar = new ArrayList<>();

        /* forms 리스트에 닉네임에서 2자리 이상의 단어 찾는 기능 */
        for (int i = 0; i < forms.size(); i++) {

            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length(); j++) {
                for (int k = j + 1; k < nickname.length(); k++) {
                    /* substring을 이용하여 2자리 이상 단어 추출 */
                    String s = nickname.substring(j, k + 1);
                    if (!ar.contains(s)) ar.add(s);
                }
            }

        }

        /* 같은 글자가 연속적으로 포함될 경우 사용제한 기능 */
        for (int i = 0; i < ar.size(); i++) {
            /* 연속적으로 단어를 포함하는 크루수인 cnt 변수 */
            int cnt = 0;

            for (int j = 0; j < forms.size(); j++) {
                /* contains을 이용하여 닉네임에 같은 단어가 포함되어 있는지 검색 */
                if (forms.get(j).get(1).contains(ar.get(i))) {
                    /* 이메일 값을 answer에 추가 */
                    answer.add(forms.get(j).get(0));
                    cnt++;
                }
            }
            /* 사용하는 크루가 혼자일시 answer에 추가한 값 제거 */
            if (cnt == 1) {
                answer.remove(answer.size() - 1);
            }
        }

        /* 오름차순으로 정렬하고 중복은 제거하는 기능 */
        TreeSet<String> ts = new TreeSet<>(answer);
        answer = new ArrayList<>(ts);

        return answer;
    }
}
