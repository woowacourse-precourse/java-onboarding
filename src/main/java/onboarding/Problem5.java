package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *
 * Class : Problem 5
 *
 * Date : 2022.10.30
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. money를 입력받아 오만 원권이 몇 개로 변환되는지 구한 후 리스트/배열에 담는다.
 * 2. 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전도 동일하게 각 몇 개로 변환되는지 구한 다음 금액이 큰 순서대로 리스트/배열에 담는다.
 * 3. 결과에 맞게 돈을 은행에서 출금한다.
 *
 * */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> wallet = new ArrayList<>();
        List<Integer> bank = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        Integer count = 0;

        // the loop that converts money
        for(int i = 0; i < 9; i++) {
            while (money >= bank.get(i)) {
                count++;
                money -= bank.get(i);
            }
            wallet.add(count);
            count = 0;
        }
        answer = wallet;
        return answer;
    }
}
