package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

/*
문제 설명
- 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우(두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함 된 경우), 해당 닉네임 사용을 제한한다.
- 같은 글자가 연속적으로 포함되는 닉네임 지원자의 이메일 목록을 반환해야 한다. 이메일 목록은 오름차순 정렬, 중복은 제거해야 한다.
*/

/*
기능 목록
- 닉네임 중 중복되는 경우가 있는지 확인하여, 중복되는 닉네임 지원자의 이메일 목록 만들기.
- 이메일 목록을 오름차순으로 정렬하고 중복은 제거하기.
*/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 이메일을 받을 때, 중복된 값 없이 받기 위해 HashSet으로 선언해준다.
        HashSet<String> answer = new HashSet<>();

        // 중복되는 닉네임을 찾아준다.
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String crew1 = forms.get(i).get(1);
                String crew2 = forms.get(j).get(1);

                for (int k = 0; k < crew1.length() - 1; k++) {
                    boolean is_same = false; // 중복되는 문자가 있을 경우, 더 이상 반복문을 돌 필요가 없으므로 이중 반복문을 탈출하기 위한 변수.

                    for (int l = 0; l < crew2.length() - 1; l++) {
                        // 각 크루원의 문자 2개를 substring으로 불러와 비교한 후, 중복될 경우 answer에 이메일을 추가해준다.
                        String crew1_substring = crew1.substring(k, k + 2);
                        String crew2_substring = crew2.substring(l, l + 2);

                        if (crew1_substring.compareTo(crew2_substring) == 0) {
                            answer.add(forms.get(i).get(0));
                            answer.add(forms.get(j).get(0));
                            is_same = true;
                            break;
                        }
                    }

                    if (is_same) {break;}
                }
            }
        }

        // HashSet을 반환 타입과 맞춰주기 위하여 List로 바꿔준다.
        List<String> answer_list = new ArrayList<>(answer);
        // 오름차순으로 정렬해준다.
        Collections.sort(answer_list);

        return answer_list;
    }
}
