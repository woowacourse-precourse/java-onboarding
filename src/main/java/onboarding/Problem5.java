package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<Moneys.values().length; i++) {
            int numOfMoneys = money / getAmountOfMoney(i);
            money -= numOfMoneys * getAmountOfMoney(i);
            answer.add(numOfMoneys);
        }
        return answer;
    }

    private static int getAmountOfMoney(int index) {
        return Moneys.values()[index].getMoney();
    }

    enum Moneys{
        FiftyThousand(50000),
        TenThousand(10000),
        FiveThousand(5000),
        OneThousand(1000),
        FiveHundred(500),
        OneHundred(100),
        Fifty(50),
        Ten(10),
        One(1);

        private int money;
        Moneys(int money) {
            this.money = money;
        }

        int getMoney() {
            return money;
        }
    }
}
