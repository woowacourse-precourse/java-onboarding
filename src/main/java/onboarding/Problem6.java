package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        /*
        1. 1번 지원자의 닉네임부터 2글자씩 분리
        2. 2~n번 지원자의 닉네임에 포함되는지 검사
        3. 포함 되는 지원자 이메일 list에 저장
        4. 다음 번호 글자 분리하면서 1~3 반복
        5. list email 오름차순으로 정렬, 중복은 제거
         */

        List<String> email = new ArrayList<>();
        List<String> nameCut = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            nameCut(forms.get(i).get(1), nameCut);
        }

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < nameCut.size(); j++) {
                if (forms.get(i).get(1).contains(nameCut.get(j))) {
                    email.add(forms.get(i).get(0));
                }
            }
        }

        return email;
    }
    // 글자 분리하는 메서드
    public static void nameCut(String name, List<String> cutname) {
        for (int i = 0; i < name.length() - 1; i++) {
            cutname.add(name.substring(i, (i + 2)));
        }
    }
}
