package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 1. 기능을 담당할 메서드 생성 후 화폐 종류를 넣을 배열 생성과 반환할 리스트 생성
* 2. 배열 길이만큼 반복하는 반복문을 통해 값을 담을 리스트인 wallet에 add, add한 금액만큼 money에서 빼주기.
* 3. wallet 반환
* */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = exchange(money);
        return answer;
    }

    public static List<Integer> exchange(int money) {
        int[] moneyTypeArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> wallet = new ArrayList<>();

        for (int i = 0; i <moneyTypeArr.length; i++) {
            if (money < moneyTypeArr[i]) {
                wallet.add(0);
            } else if (money >= moneyTypeArr[i]) {
                wallet.add(money / moneyTypeArr[i]);
                money = money - (money / moneyTypeArr[i]) * moneyTypeArr[i];
            }
        }
        return wallet;
    }
}
