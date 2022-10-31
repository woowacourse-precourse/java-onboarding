package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int diverseMoney = 0; // 몫을 저장하는 변수

        // 1. number를 50000으로 나눈 몫 만큼 arr[0] 추가. number -=50000*몫
        // 2. 바뀐 money 값을 10000으로 나눈 몫 만큼 리스트에 추가 number-=10000*몫
        // 3. 바뀐 money 값을 5000으로 나눈 몫 만큼 리스트에 추가 number-=5000*몫
        // 4. 바뀐 money 값을 1000으로 나눈 몫 만큼 리스트에 추가 number-=1000*몫
        // 5. 바뀐 money 값을 500으로 나눈 몫 만큼 리스트에 추가 number-=500*몫
        // 6. 바뀐 money 값을 100으로 나눈 몫 만큼 리스트에 추가 number-=100*몫
        // 7. 바뀐 money 값을 50으로 나눈 몫 만큼 리스트에 추가 number-=50*몫
        // 8. 바뀐 money 값을 10으로 나눈 몫 만큼 리스트에 추가 number-=10*몫
        // 9. 남은 값을 리스트에 추가 or 1로 나눈 몫 값을 리스트에 추가

        ArrayList<Integer> emptyList = new ArrayList<Integer> ();
        List<Integer> moneyList = new ArrayList<Integer>();
        moneyList.add(50000); moneyList.add(10000); moneyList.add(5000); moneyList.add(1000); moneyList.add(500);
        moneyList.add(100);  moneyList.add(50); moneyList.add(10); moneyList.add(1);
        for(int i=0; i < moneyList.size(); i++){
            diverseMoney = money / moneyList.get(i);
            emptyList.add(diverseMoney);
            money -= (diverseMoney * moneyList.get(i));
        }



        System.out.println(emptyList);

//        List<Integer> answer = Collections.emptyList();
//        return answer;
        return emptyList;
    }
}
