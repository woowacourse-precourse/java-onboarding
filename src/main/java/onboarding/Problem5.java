package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        validateCase(money);

            int fTThousand = money / 50000;
            answer.add(fTThousand);
            int TThousand = (money % 50000 ) / 10000;
            answer.add(TThousand);
            int fThousand = ( money % 10000 ) / 5000;
            answer.add(fThousand);
            int thousand = ( money % 5000 ) / 1000;
            answer.add(thousand);
            int fHundred = ( money % 1000 ) / 500; //
            answer.add(fHundred);
            int hundred = ( money % 5000 ) / 100;
            answer.add(hundred);
            int fifty = ( money % 100) / 50; //
            answer.add(fifty);
            int ten = (money % 50 ) / 10;
            answer.add(ten);
            int one = money % 10 ;
            answer.add(one);

        return answer;
    }

    public static void validateCase(int money){
        if( money < 1 || money > 1000000) throw new RuntimeException("돈의 금액이 범위에 적합하지 않습니다.");
    }
}
