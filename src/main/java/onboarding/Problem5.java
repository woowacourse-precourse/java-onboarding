package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 지폐의 금액들을 담은 리스트를 만들고, 큰 수로 나눠가며 몫을 배열에 추가해나간다.
 * 오만 원권은 만 원권 5장과 같고, 만 원권은 오천 원권 2장과 같다. 즉 작은 지폐로 큰 지폐를 만드는 것은 항상 가능하다.
 * 그렇기에 큰 금액부터 나눠가며 지폐를 추가해나가도 money를 '남는 금액 없이' 모두 변환하는 것이 가능하다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bill = List.of(50000,10000,5000,1000,500,100,50,10,1);


        for(int i = 0; i<bill.size();i++){
            answer.add(money/bill.get(i));
            money%=bill.get(i);
        }

        return answer;
    }
}
