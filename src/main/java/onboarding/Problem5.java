package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
##기능 목록

1. 단위 지폐 목록을 담은 List 생성
2. 입력 값을 단위 지폐로 나눠 몫을 결과 List에 저장
3. 결과 반환

 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> unitMoneyList = initUnitList();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<unitMoneyList.size();i++){
            int count = money / unitMoneyList.get(i);
            money %= unitMoneyList.get(i);
            result.add(count);
        }
        answer = result;
        return answer;
    }

    public static List<Integer> initUnitList(){
        List<Integer> list = new ArrayList<>();
        list.add(50000);
        list.add(10000);
        list.add(5000);
        list.add(1000);
        list.add(500);
        list.add(100);
        list.add(50);
        list.add(10);
        list.add(1);
        return list;
    }
}
