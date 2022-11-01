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
        String[] name = new String[20];

        for (int i = 0; i < forms.size(); i++) {
            name = nameCut(forms.get(i));
            System.out.println(name);
        }

        return email;
    }
    // 글자 분리하는 메서드
    public static String[] nameCut(List<String> name) {
        String[] cutname = new String[20];
        for (int i = 0; i < name.size() - 2; i++) {
            cutname[i] = name.get(1).substring(i, (i + 2));
        }
        return cutname;
    }
}
