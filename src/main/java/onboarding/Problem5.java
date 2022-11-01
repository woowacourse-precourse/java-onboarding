package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        System.out.println("money = " + money);
        List<Integer> answer = currencyConversion(money);
        System.out.println("answer = " + answer);
        return answer;
    }

    public static List<Integer> currencyConversion(int money){
        // 화폐 단위를 목록화
        int [] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 결과를 담을 배열 초기화
        List<Integer> countCurrency = new ArrayList<>();
        // 전달인자 값 변수에 저장
        int calculation = money;
        // 화폐 단위 만큼 반복문 실행
        for(int i=0; i<currency.length; i++){
            // 입력 숫자를 화폐 단위 순서대로 조회 및 변수 초기화 결과를 리스트에 저장
            if(calculation>currency[i]){
                int result = calculation/currency[i];
                calculation = calculation%currency[i];
                countCurrency.add(result);
            }else{
                // 입력 숫자가 화페 단위보다 작을 경우 0 추가
                countCurrency.add(0);
            }
        }
        return countCurrency;
    }
}
