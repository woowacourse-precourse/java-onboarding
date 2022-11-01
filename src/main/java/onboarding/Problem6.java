package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        /*
        1. 지원자의 닉네임부터 2글자씩 분리 후 저장
        2. 2~n번 지원자의 닉네임에 포함되는지 검사 / 포함 되는 지원자 이메일 list에 저장
        3. list email 오름차순으로 정렬, 중복은 제거
         */

        List<String> email = new ArrayList<>();
        List<String> nameCut = new ArrayList<>();
        int num = 0;

        for (int i = 0; i < forms.size(); i++) {
            num = nameCut.size();
            nameCut(forms.get(i).get(1), nameCut);
            for (int j = 0; j < forms.size(); j++) {
                if (i != j) {
                    duplicateName(forms.get(j), nameCut, email, num);
                }
            }
        }

        TreeSet<String> email1 = new TreeSet<>(email);
        List<String> email2 = new ArrayList<>(email1);

        return email2;
    }
    // 글자 분리하는 메서드
    public static void nameCut(String name, List<String> cutname) {
        for (int i = 0; i < name.length() - 1; i++) {
            cutname.add(name.substring(i, (i + 2)));
        }
    }

    public static void duplicateName(List<String> name, List<String> cutname, List<String> email, int num) {
        for (int k = num; k < cutname.size(); k++) {
            if (name.get(1).contains(cutname.get(k))) {
                email.add(name.get(0));
            }
        }
    }
}
