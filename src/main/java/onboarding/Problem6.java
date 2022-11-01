package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 크루들간의 닉네임 중 연속적으로 포함된 닉네임을 갖고있는 크루들의 이메일 리턴
        - 각각의 크루의 닉네임을 2단어씩 나눠 HashSet에 저장(메모리 효율위해)
        - 각각의 크루들 중 나눠진 닉네임이 겹치는 크루들의 이메일을 List에 저장
        - 저장된 이메일 List의 문자열 원소들을 오름차순으로 정렬하고 중복 제거
     */
    HashSet<String> split_name(String name) {
        HashSet<String> result = new HashSet<>(); // 크루의 닉네임을 2단어씩 나눠 HashSet에 저장(메모리 효율위해)
        for (int i = 0; i < name.length() - 1; i++) {
            result.add(name.substring(i, i + 2));   // 최소 중복 조건으로 나눔
        }
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Problem6 p6 = new Problem6();
        List<HashSet> splited_forms = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            splited_forms.add(p6.split_name(forms.get(i).get(1))); // 닉네임만 가져와서 splited_forms List에 추가
        }

        return answer;
    }
}
