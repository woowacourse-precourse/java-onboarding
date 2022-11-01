package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        /*
         * 기능 요구 사항
         * 3. 닉네임 중복인 회원의 이메일을 오름차순으로 정렬해서 반환
         * */

        answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (duplicate_str(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        answer = sort_by_email(answer);
        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 닉네임 글자 중복을 확인하기
     * */

    private static boolean duplicate_str(String str_a, String str_b) {
        for (int i = 0; i < str_a.length() - 1; i++) {
            if (str_b.contains(str_a.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    /*
     * 기능 요구 사항
     * 2. 이메일로 정렬하기
     * */

    private static List<String> sort_by_email(List<String> list) {
        Set<String> new_set = new HashSet<>(list);
        List<String> new_list = Lists.newArrayList(new_set);
        Collections.sort(new_list);
        return new_list;
    }
}
