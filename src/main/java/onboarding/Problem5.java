package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!checkValidation(money)){
            return null;
        }
        answer = getListOfBill(money);;
        return answer;
    }

    private static boolean checkValidation(int money){
        if(1<=money && money<=1000000){
            return true;
        }
        return false;
    }

    private static List<Integer> getListOfBill(int money){
        List<Integer> listOfMoney = getListOfMoney();
        List<Integer> billsOfMoney = getLeastBills(money, listOfMoney);
        return billsOfMoney;
    }

}
