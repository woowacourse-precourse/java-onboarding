package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        //Using ArrayList because Collections can not be modified
        List<Integer> answer = new ArrayList<>() ;
        //Make the List that contains units of the money
        List<Integer> unitMoney = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (int i = 0; i < unitMoney.size(); ++i) {
            answer.add( money / unitMoney.get(i) );
            money = money % unitMoney.get(i) ;
        }
        return answer;
    }
}
