package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = initResultList();
        ArrayList<Integer> moneyList = initMoneyList();
        for (int i = 0; i <= 8; i++) {
            money = convertMoneyByParams(answer, moneyList, money, i);
        }
        return answer;
    }

    // 결과값을 저장할 배열을 초기화하는 함수
    public static ArrayList<Integer> initResultList() {
        ArrayList<Integer> resultList = new ArrayList<Integer>(9);
        return resultList;
    }

    // 금액 변환을 위한 배열을 초기화하는 함수
    public static ArrayList<Integer> initMoneyList() {
        ArrayList<Integer> MoneyList = new ArrayList<Integer>(9);
        MoneyList.add(50000);
        MoneyList.add(10000);
        MoneyList.add(5000);
        MoneyList.add(1000);
        MoneyList.add(500);
        MoneyList.add(100);
        MoneyList.add(50);
        MoneyList.add(10);
        MoneyList.add(1);
        return MoneyList;
    }

    // 주어진 금액에 대해 x원권으로 변환하고 이를 리턴하는 함수
    public static Integer convertMoneyByParams(List<Integer> answer, ArrayList<Integer> moneyList, Integer money, Integer index) {
        answer.add(money / moneyList.get(index));
        return money % moneyList.get(index);
    }
}
