package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {



    public static List<Integer> solution(int money) {
        return exchangeAllMoney(money);
    }

    /**
     * [입력받은 돈의 단위로 최대 화폐의 갯수 구하기]
     * - 입력받은 돈의 최대 화폐 갯수를 반환한다.
     * @param unitOfMoney 돈 단위
     * @param money 남은 돈
     * @return 화폐의 갯수
     */
    public static int exchangeMoney(int unitOfMoney, int money) {
        return money / unitOfMoney;
    }


    /**
     * [각 화폐 단위의 모든 갯수 구하기]
     * - exchangeMoney()를 사용한다.
     * - 각 화폐 단위의 모든 갯수를 구해 반환한다.
     * @param money
     * @return 각 화폐의 모든 갯수.
     */
    public static List<Integer> exchangeAllMoney(int money){
        List<Integer> numberOfMoney = new ArrayList<>();
        List<Integer> unitOfMoneys = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        for (int unitOfMoney : unitOfMoneys) {
            int unit = exchangeMoney(unitOfMoney,money);
            numberOfMoney.add(unit);
            money -= unitOfMoney * unit;
        }
        return numberOfMoney;
    }
}
