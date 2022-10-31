package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> tmpList = new ArrayList<String>();

        tmpList = bruteForce(forms);

        List<String> collect = tmpList.stream().distinct().collect(Collectors.toList()); // 중복 제거
        collect.sort(Comparator.naturalOrder()); // 오름차순 정렬

        answer = collect;

        return answer;
    }

    // 모든 경우의 수 탐색
    private static List<String> bruteForce(List<List<String>> forms) {

        List<String> tmpList = new ArrayList<String>(); // 임시 리스트

        for (int i = 0; i < forms.size(); i++) {

            List<String> target = forms.get(i); // 모든 닉네임을 한번씩 기준으로 설정 함
            int count = 1; // 중복되는 닉네임 수(기준이 되는 닉네임이 존재하므로 초기값 1로 설정 => 즉, count 가 2개 이상이 되면 닉네임이 중복된 걸로 간주)

            for (int j = 0; j != i && j < forms.size(); j++) {
                if (check(target.get(1), forms.get(j).get(1))) {
                    count += 1;
                    tmpList.add(forms.get(j).get(0)); // 기준 닉네임과 비교해서 중복되는 닉네임이 있으면 임시 리스트에 추가해줌
                }
            }

            // 중복되는 닉네임이 2개 이상이면 기준 닉네임도 추가
            if (count >= 2) {
                tmpList.add(target.get(0));
            }
        }

        return tmpList;
    }

    // target 을 기준으로 name 과 연속적으로 중복되는 문자열이 있는지 확인
    private static boolean check(String target, String name) {

        return false;
    }
}