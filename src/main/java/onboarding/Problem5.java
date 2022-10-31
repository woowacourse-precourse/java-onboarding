package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1. 돈의 화폐단위가 들어있는 리스트 생성
2. 리스트를 순회하면서 money = money % 화폐단위, money / 화폐단위를 answer 리스트에 추가한다.
 */
public class Problem5 {
    public static void main(String args[]){
        List<Integer> result = solution(50237);
        System.out.println(result);
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> money_list = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        for (int m : money_list) {
            answer.add(money / m);
            money = money % m;
        }
        return answer;
    }
}
