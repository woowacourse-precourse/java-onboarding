package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MONEY_LOWERBOUND = 1;
    static final int MONEY_UPPERBOUND = 1_000_000;
    static final List<Integer> MONEY_LIST = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static boolean validationCheck(int money) {
        if (MONEY_LOWERBOUND <= money && money <= MONEY_UPPERBOUND) {
            return true;
        }
        return false;
    }
    public static List<Integer> splitMoney(int money) {
        List<Integer> resultList = Arrays.asList(0,0,0,0,0,0,0,0,0);
        for (int i = 0; i < MONEY_LIST.size(); i++) {
            int baseMoney = MONEY_LIST.get(i);
            if (isBigger(money, baseMoney)) {
                int divi = getQuotient(money, baseMoney);
                money = updateMoney(money, baseMoney);
                resultList.set(i, divi);
            }
        }
        return resultList;
    }
    public static boolean isBigger(int money, int baseMoney) {
        if (money > baseMoney) {
            return true;
        }
        return false;
    }
    public static int getQuotient(int money, int baseMoney) {
        int quotient = money / baseMoney;
        return quotient;
    }
    public static int updateMoney(int money, int baseMoney) {
        int updatedMoney = money % baseMoney;
        return updatedMoney;
    }
}


/*
* 1. 입력 조건에 맞지 않는 경우 예외처리 기능
- money가 1 이상 1,000,000 이하의 자연수인지 체크
2. money가 총 몇 개의 화폐로 구성될 수 있는지 계산하는 기능
3. money가 해당 화폐로 나누어지는지 확인하는 기능
4. money를 해당 화폐로 나누고 나눈 몫을 반환하는 기능
5. 화폐로 나누어짐에 따라 money를 갱신하는 기능
* */