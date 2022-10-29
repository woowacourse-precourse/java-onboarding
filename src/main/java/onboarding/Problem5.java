package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    static int[] unitOfMoney;

    public static List<Integer> solution(int money) {
        List answer = exchangeMoney(money);
        return answer;
    }

    public static List exchangeMoney(int money) {
        unitOfMoney = new int[9];

        if (money >= 50000) {
            int moneyCount = money / 50000;
            money %= 50000;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[0]++;
            }
        }
        if (money >= 10000) {
            int moneyCount = money / 10000;
            money %= 10000;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[1]++;
            }
        }
        if (money >= 5000) {
            int moneyCount = money / 5000;
            money %= 5000;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[2]++;
            }
        }
        if (money >= 1000) {
            int moneyCount = money / 1000;
            money %= 1000;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[3]++;
            }
        }
        if (money >= 500) {
            int moneyCount = money / 500;
            money %= 500;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[4]++;
            }
        }
        if (money >= 100) {
            int moneyCount = money / 100;
            money %= 100;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[5]++;
            }
        }
        if (money >= 50) {
            int moneyCount = money / 50;
            money %= 50;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[6]++;
            }
        }
        if (money >= 10) {
            int moneyCount = money / 10;
            money %= 10;
            for (int i = 0; i < moneyCount; i++) {
                unitOfMoney[7]++;
            }
        }
        if (money < 10) { //1원짜리만 있을 때
            for (int i = 0; i < money; i++) {
                unitOfMoney[8]++;
            }
        }
        List MoneyTypeToList = Arrays.stream(unitOfMoney).boxed().collect(Collectors.toList());

        return MoneyTypeToList;
    }

}
