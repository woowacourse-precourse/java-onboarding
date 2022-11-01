package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> arr; //지폐 갯수를 담을 배열
    private static int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //금액
    public static List<Integer> solution(int money) {
        arr = new ArrayList<>();
        List<Integer> answer = calculation(money);
        return answer;
    }

    //지폐 갯수를 계산하는 기능
    public static List<Integer> calculation(int money) {
        int count = 0; //지폐 갯수 저장

        for(int i = 0 ; i < 9 ; i++){
            while(money / moneyArr[i] > 0) { //지폐로 나눈 몫이 0보다 크면 반복해서 금액을 차감하는 기능
                count += 1; //갯수 + 1
                money -= moneyArr[i]; //금액 차감
            }
            //지폐 별 총 갯수를 저장하는 기능
            arr.add(count); //갯수 저장
            count = 0; //갯수 초기화
        }

        return arr;
    }

}
