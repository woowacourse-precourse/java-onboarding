package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> answer = new ArrayList<>();

        Problem6 p6 = new Problem6();
        List<HashSet> splited_forms = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            splited_forms.add(p6.split_name(forms.get(i).get(1))); // 닉네임만 가져와서 splited_forms List에 추가
        }

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i+1; j < forms.size(); j++) {  // 2개의 HashSet의 교집합을 통해서 겹치는게 있는지 확인
                HashSet<String> common = new HashSet<>(splited_forms.get(i)); // 교집합 사용하기위해 세팅
                common.retainAll(p6.split_name(forms.get(j).get(1)));   // 두 개의 HashSet의 교집합
                if (!common.isEmpty()) {    // 중복 조건이 성립되는 경우(두 개의 HashSet의 교집합이 존재한 경우)
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        // 저장된 이메일 List의 문자열 원소들을 오름차순으로 정렬하고 중복 제거
        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
}
