package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = moneyList(money);
        return answer;
    }

    private static List<Integer> moneyList(int money){
        List<Integer> lst = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> result = new ArrayList<>();

        // money는 1 이상 1,000,000 이하인 자연수이다.
        if (1 > money || 1000000 < money) {
            return null;
        }

        // 각 지폐와 동전을 확인하여 최대한 큰 금액의 화폐가 주어지도록 한다.
        for(int i = 0; i < lst.size(); i++){
            if(money >= lst.get(i)) {
                result.add(money / lst.get(i));
                money = money % lst.get(i);
            }
            else if(money < lst.get(i)){
                result.add(0);
            }
        }
        return result;
    }
}
