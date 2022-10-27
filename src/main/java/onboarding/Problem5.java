package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static List<Integer> answer;    // 클래스변수 answer 선언
    public static List<Integer> solution(int money) {
        answer = new ArrayList<>(9);    // answer 초기화
        moneyCalculation(money, 0);
        return answer;
    }

    static void moneyCalculation(int money, int num){
        int[] money_list = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 단위 화폐들을 담은 money_list 선언
        int number = 0; // 단위 화폐의 개수를 담을 number 변수 선언

        if(money >= money_list[num]){
            number = money/money_list[num];
            answer.add(number);
            money = money - (number*money_list[num]);
            num += 1;
        } else if(money < money_list[num]){
            answer.add(number);
            num += 1;
        }
        if(num <9) {    // 계산 횟수 8번 까지만 재귀함수 실행
            moneyCalculation(money, num);
        }
    }
}
