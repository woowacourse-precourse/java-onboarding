package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 화폐별 사용되는 개수를 구하는 함수 billNumber()

        // emptyList였던 answer를 가변적인 arrayList로 변경
        List<Integer> answer = new ArrayList<>();

        // 액수가 큰 순서대로 bill_list 구성
        int[] bil_list = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int length = bil_list.length;

        for (int i = 0; i < length; i++) {
            int result = billNumber(money, bil_list[i]);
            money -= result * bil_list[i];
            answer.add(result);
        }
        return answer;
    }

    public static Integer billNumber(int money, int bill) {
        int result = 0;

        while (money >= bill) {
            result += 1;
            money -= bill;
        }

        return result;
    }
}
