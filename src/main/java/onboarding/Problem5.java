package onboarding;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /* 50237
     * 1. 돈은 1000000 이하 0 이상이다.
     * 2. 50000원권 몇개 인지 확인     1
     * 3. 10000원권 몇개 인지 확인     0
     * 4. 5000원권 몇개 인지 확인      0
     * 5. 1000원권 몇개 인지 확인      0
     * 6. 500원권 몇개 인지 확인       0
     * 7. 100원권 몇개 인지 확인       2
     * 8. 50원권 몇개 인지 확인        0
     * 9. 10원권 몇개 인지 확인        3
     * 10. 1원권 몇개 인지 확인        7
     * 리스트에 담아주고 반환함
     * */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if(money > 1000000 || 0 > money){
            throw new RuntimeException("규칙에 위반 됩니다.");
        }
        List<Integer> target = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> value = new ArrayList<>();
        for (int i: target) {
            System.out.println("value : " + money/i);
            value.add(money/i);
            money = money%i;
        }
        answer = value;

        return answer;
    }
}
