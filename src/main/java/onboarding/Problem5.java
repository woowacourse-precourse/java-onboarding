package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 각각 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전을 의미
    static final int[] MONEY_UNIT = {
            50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    };
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        // 기능#1 숫자가 큰 순서대로 지폐/동전 단위 별로 나누고, 그 몫을 리스트/배열 형태로 저장하는 기능
        // MONEY_UNIT.length-1은 1원은 나눗셈/나머지 연산자가 무의미하기 때문
        for(int index = 0; index < MONEY_UNIT.length-1; ++index) {
            int currentMoneyUnit = MONEY_UNIT[index];
            answer.add(money / currentMoneyUnit);
            money %= currentMoneyUnit;
        }
        // MONEY_UNIT.length-1에서 계산하지 않은 일원 동전 갯수 계산
        answer.add(money);
        return answer;
    }
}
