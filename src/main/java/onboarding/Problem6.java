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

        return tmpList;
    }
}