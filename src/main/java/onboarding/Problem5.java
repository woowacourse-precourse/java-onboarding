package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i=10000; i>0; i/=10){
            if(i == 1){
                answer.add(money);
                break;
            }
            List<Integer> list = divideUnit(money / i);
            answer.add(list.get(0));
            answer.add(list.get(1));

            money %= i;
        }
        return answer;
    }
    private static List<Integer> divideUnit(int money){
        List<Integer> list = new ArrayList<>();
        //5의 단위 화폐 개수
        list.add(money / 5);
        //1의 단위 화폐 개수
        list.add(money % 5);
        return list;
    }

}
