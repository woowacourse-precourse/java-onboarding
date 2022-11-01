package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

    private static List<Integer> getListOfMoney(){
        return List.of(50000,10000,5000,1000,500,100,50,10,1);
    }

    private static List<Integer> getLeastBills(int money, List<Integer> moneyList){
        Map<Integer,Integer> billStorage = new HashMap<>();
        moneyList.iterator().forEachRemaining(a -> billStorage.put(a,0));
        calculateLeastBill(money,billStorage);
        return billStorage.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .map(a->billStorage.get(a))
                .collect(Collectors.toList());
    }

    private static void calculateLeastBill(int money, Map moneyStorage){
        List<Integer> listOfUsableBill = new ArrayList<>(moneyStorage.keySet());
        Collections.sort(listOfUsableBill, Collections.reverseOrder());
        while(money!=0){
            for(int bill : listOfUsableBill){
                moneyStorage.put(bill, money/bill);
                money%=bill;
            }
        }
    }
}
