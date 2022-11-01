package onboarding;

import java.util.*;

public class Problem5 {

    //화폐 종류 변동시 대소관계에 상관 없이 currencyList에 추가한다.
    public static Integer[] currencyList = new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        init();
        List<Integer> answer = new ArrayList<>();
        for(int currency : currencyList){
            answer.add(money/currency);
            money%=currency;
        }
        return answer;
    }

    public static void init(){
        Arrays.sort(currencyList, Collections.reverseOrder());
    }

}
