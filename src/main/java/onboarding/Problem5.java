package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyList = new ArrayList<>(List.of(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> answer = new ArrayList<>();
        change(money,moneyList,answer);
        return answer;
    }

    // 주어진 money에서 50000 to 1 까지 거스름돈이 발생하지 않는 선에서 빼가며 사용 개수를 구하는 함수
    public static void change(int money, List<Integer> moneyList, List<Integer> answer){
        for(int i=0; i<moneyList.size(); i++){
            int count = money / moneyList.get(i);
            if(count > 0){
                answer.add(count);
                money -= (count * moneyList.get(i));
            }else{
                answer.add(0);
            }
        }
    }
}
