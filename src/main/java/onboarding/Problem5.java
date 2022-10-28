package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();

        answer = divisionMoney(money);

        return answer;
    }

    public static List<Integer> divisionMoney(int money) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < 9 ; i++){

            switch (i){
                case 0 :
                    money = addMoney(result, money ,50000); break;
                case 1 :
                    money = addMoney(result, money ,10000); break;
                case 2 :
                    money = addMoney(result, money ,5000); break;
                case 3 :
                    money = addMoney(result, money ,1000); break;
                case 4 :
                    money = addMoney(result, money ,500); break;
                case 5 :
                    money = addMoney(result, money ,100); break;
                case 6 :
                    money = addMoney(result, money ,50); break;
                case 7 :
                    money = addMoney(result, money ,10); break;
                case 8 :
                    money = addMoney(result, money ,1); break;
            }
        }

        return result;
    }

    private static int addMoney(List<Integer> result, int money, int divMoney) {
        result.add(money / divMoney);
        return money % divMoney;
    }

}
