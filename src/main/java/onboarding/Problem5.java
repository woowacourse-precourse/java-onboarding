package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LightWallet {
    /**
     * 나라마다 사용하는 화폐의 종류가 다를 수 있다.
     * 따라서, 인스턴스를 생성해서 매소드를 호출하는 것이 좋다.
     */

    List<Integer> moneyTypes;

    public LightWallet() {
        Integer[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 코드의 가독성을 위해 배열을 만들고 그 배열로 ArrayList를 만들었습니다.
        moneyTypes = new ArrayList<>(Arrays.asList(moneyArray));
    }

    public void countMoney(int inputMoney, List<Integer> answer) {
        /**
         * 입력받은 금액을 각각 몇 개의 지폐들로 반환이 되는지 새어주는 메소드
         */

        int moneyCount;

        for (Integer money : moneyTypes) {
            moneyCount = inputMoney / money;
            answer.add(moneyCount);
            inputMoney %= money;
        }
    }

}

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        LightWallet wallet = new LightWallet();

        wallet.countMoney(money, answer);

        return answer;
    }
}
