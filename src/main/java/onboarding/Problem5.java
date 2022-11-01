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


        int[] money_note = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 화폐 단위에 대한 배열 선언

        // 각 화폐의 개수 정보를 담을 리스트를 배열로 변환 (List 원소 변경 메서드 set이 오류가 발생하여 배열로 변경시도)
        int[] money_array = result.stream().mapToInt(i->i).toArray();

        // 각 화폐가 사용되는 개수를 구하기
        for (int i = 0; i < money_note.length; i++){
            int count = 0;
            count = (int) (money / money_note[i]); // 해당 화폐를 사용할 수 있는 개수 구하기
            money %= money_note[i]; // 사용된 화폐를 제외한 나머지 금액을 다시 money에 저장
            money_array[i] = count; // 해당 화폐 단위 위치에 화폐를 사용할 수 있는 개수를 저장
        }

        // 각 계산된 화폐 단위의 개수가 담긴 배열을 List 타입으로 변환
        result = Arrays.stream(money_array).boxed().collect(Collectors.toList());


        //System.out.println(result);

        List<Integer> answer = result;
        return answer;
    }
}
