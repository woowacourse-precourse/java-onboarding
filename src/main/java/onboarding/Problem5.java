package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();//빈 리스트를 출력해야될 떄 사용한다.
        //따라서 예외 발생했다면 빈 리스트를 출력한다. 또는 -1 정도?
        if(money <= 0){return answer;}

        //화폐단위 초기화
        List<Integer> Unit = List.of(50000,10000,5000,1000,500,100,50,10,1);
        answer =new ArrayList<Integer>();
        int size = Unit.size();
        //answer 초기화 동시에 지폐단위가 큰것부터 저장 왜냐하면 똑같은 for 문을 두번돌리는 것보다 한번에 처리하는게 연산속도가 빨라질것이라고
        //생각
        for(int i = 0; i< size ; i++){
            int a = money / Unit.get(i);
            answer.add(a);
            money -= a * Unit.get(i);
        }

        System.out.println(answer);








        return answer;
        }


}
