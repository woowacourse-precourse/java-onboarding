package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int fiftyThousandWonBill = fiveTimesUnitCalculate(money,10000);
        while(money / 10000 >= 5) money -= 50000;

        int tenThousandWonBill = unitCalculate(money,10000);
        while(money / 10000 != 0) money -= 10000;

        int fiveThousandWonBill = fiveTimesUnitCalculate(money,1000);
        while(money / 1000 >= 5) money -= 5000;

        int oneThousandWonBill = unitCalculate(money,1000);
        while(money / 1000 != 0) money -= 1000;

        int fiveHundredWonCoin = fiveTimesUnitCalculate(money,100);
        while(money / 100 >= 5) money -= 500;

        int hundredWonCoin = unitCalculate(money,100);
        while(money / 100 != 0) money -= 100;

        int fiftyWonCoin = fiveTimesUnitCalculate(money,10);
        while(money / 10 >= 5) money -= 50;

        int tenWonCoin = unitCalculate(money,10);
        while(money / 10 != 0) money -= 10;

        int oneWonCoin = 0;
        while(money != 0){
            money -= 1;
            oneWonCoin++;
        }
        List<Integer> answer = List.of(fiftyThousandWonBill,tenThousandWonBill,fiveThousandWonBill, oneThousandWonBill,
                fiveHundredWonCoin, hundredWonCoin,fiftyWonCoin,tenWonCoin,oneWonCoin);
        return answer;
    }
    public static int fiveTimesUnitCalculate(int money,int digit){
        int currentMoney = money;
        int fiveTimesUnit =0;

        while(currentMoney / digit >= 5){
            fiveTimesUnit++;
            currentMoney -= 5*digit;
        }
        return fiveTimesUnit;
    }
    public static int unitCalculate(int money, int digit){
        int currentMoney = money;
        int unit=0;

        while(currentMoney / digit > 0){
            unit++;
            currentMoney -= digit;
        }

        return unit;
    }
}
