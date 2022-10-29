package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {

    private static final List<Integer> collection_of_money_type = List.of(50000,10000,5000,1000,500,100,50,10,1);

    private static Integer calculateNumOfMoney(int money, Integer type_of_money){
        return money / type_of_money;
    }
    public static List<Integer> solution(int money) throws UnsupportedOperationException{
        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        for (int i = 0;i<collection_of_money_type.size();i++){
            answer.add(calculateNumOfMoney(money,collection_of_money_type.get(i)));
            money %= collection_of_money_type.get(i);
        }

        return answer;
    }
}
