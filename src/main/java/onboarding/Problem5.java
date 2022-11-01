package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    // 기능 구현 목록
    // 1. 예외처리 (money가 1 이상 10,000이하의 자연수가 인 경우)
    // 2. 각 화폐가 사용되는 개수를 구하고 반환 형식에 맞게 변환
    public static List<Integer> solution(int money) {
        List <Integer> result = List.of(0,0,0,0,0,0,0,0,0); // 각 화폐의 개수 정보를 담을 리스트 선언

        // 예외처리
        // 1. money가 1 이상 10,000이하의 자연수가 아니라면
        if (!(1 <= money && 1000000 >= money)) {
            result = List.of(-1);
            return result;
        }

        List<Integer> answer = result;
        return answer;
    }
}
