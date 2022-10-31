package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int leftMoney = money;
        int count;


        //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원
        for(int i = 10000; i > 2; i/=10)
        {
            count = leftMoney / (i*5);
            leftMoney %= i*5;

            answer.add(count);

            count = leftMoney / i;
            leftMoney %= i;

            answer.add(count);
        }
        count = leftMoney;
        answer.add(count);


        return answer;
    }
}
