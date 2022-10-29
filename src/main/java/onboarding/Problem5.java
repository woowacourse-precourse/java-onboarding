package onboarding;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * > 요구사항
 * 1. money를 저장
 * 2. 반복문을 돌면서 money가 큰 수부터 차례로 최대한 많이 가져온다.
 * 3. 각 단위 별로 가져온 배열을 출력
 */
public class Problem5 {

    public static List<Integer> solution(int money) {
        int[] moneyUnit = new int[]{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        int[] result = new int[moneyUnit.length];
        int idx = 0;
        
        while (money > 0) {
            if (money >= moneyUnit[idx]) {
                result[idx] += money / moneyUnit[idx];
                money %= moneyUnit[idx];
            }
            idx += 1;
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
