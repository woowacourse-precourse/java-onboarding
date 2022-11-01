package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        Money input = new Money(money);

        List<Integer> answer = new ArrayList<>();
        //제일 큰 단위부터 체크해야 조건에 맞음
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int count;
        for (int i = 0; i < unit.length; i++) {
            // 현재 금액권으로 해결할 수 있는 돈
            count = money / unit[i];
            answer.add(count);
            // 나머지 금액
            money = money % unit[i];
        }
        return answer;
    }
}

class Money {

    private int money;

    public Money(int money){
        validateSize(money);
        this.money = money;
    }

    private void validateSize(int money) {
        if (money < 1) {
            throw new IllegalArgumentException("0원 이하는 입력할 수 없습니다.");
        }
        If (money > 1000000) {
            throw new IllegalArgumentException("1000000원 이하로 입력해주세요.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}

