package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        // 몫은 해당 금액의 개수, 나머지는 뒤로 넘기면서 반복
        // 10원 계산할 차례에서는 몫은 10원의 개수/나머지는 1원의 개수

        int num = money/50000;
        int remainMoney = money%50000;
        answer.add(num);

        num = remainMoney/10000;
        remainMoney = remainMoney%10000;
        answer.add(num);

        num = remainMoney/5000;
        remainMoney = remainMoney%5000;
        answer.add(num);

        num = remainMoney/1000;
        remainMoney = remainMoney%1000;
        answer.add(num);

        num = remainMoney/500;
        remainMoney = remainMoney%500;
        answer.add(num);

        num = remainMoney/100;
        remainMoney = remainMoney%100;
        answer.add(num);

        num = remainMoney/50;
        remainMoney = remainMoney%50;
        answer.add(num);

        num = remainMoney/10;
        remainMoney = remainMoney%10;
        answer.add(num);
        answer.add(remainMoney);

        return answer;
    }
}
