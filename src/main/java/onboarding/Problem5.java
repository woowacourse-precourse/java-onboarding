package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    /*기능구현
    예외처리 : money의 범위가 1보다 작거나, 1000000보다 클 때, 예외
    1. 단위가 큰 금액부터 money를 나누고 그 나머지를 다음으로 큰 금액이 나눈다.
    moneyUnit의 길이만큼 반복하는 함수를 구현.
    * */


    public static List<Integer> transMoney(int num) {
        List<Integer> result = new ArrayList<>();
        int[] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int unit : moneyUnit) {
            result.add(num / unit);
            // num 값 갱신
            num %= unit;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        // 제한사항 고려
        try {
            if(money > 0 && money < 1000001){
                answer = transMoney(money);
            }
        }catch(IllegalArgumentException e){
            System.out.println("money of range(Input) error");
        }

        return answer;
    }
}
