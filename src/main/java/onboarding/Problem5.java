package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        getAnswer(money, answer);

        return answer;
    }

    //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
    private static List<Integer> getAnswer(int n, List<Integer> list) {
        List<Integer> billList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int bill: billList) {
            list.add(n / bill);
            n %= bill;
        }

        return list;
    }

}
