package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    //화폐 금액별 배열, 저장할 배열 만들고 화폐단위별로 나누면서 결과를 저장하고, 반환
    static List<Integer> getCount (int money){
        List<Integer> result = new ArrayList<>();
        int[] pay = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0; i<pay.length; i++){
            int temp = money/pay[i];
            money = money%pay[i];
            result.add(temp);
        }

        return result;
    }


    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = getCount(money);

        return answer;
    }
}
