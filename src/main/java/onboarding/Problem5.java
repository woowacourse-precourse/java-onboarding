package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        result = [0, 0, 0, 0, 0, 0, 0, 0, 0] // 5만원권, 1만원권, 5천원권, 1천원권, 500원권, 100원권, 50원권, 10원권, 1원권의 인덱스를 만들어줌
        monetary unit = [50000, 10000, 5000, 1000, 500, 100, 50, 10, 1] 
        for i in range(9):
            reult[i] = money%monetary unit[i] // 해당 인덱스에 따라 높은 지폐권종으로 몫을 구해서 리스트 값 갱신
        return result;
    }
}
