package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));

        // while 문을 이용하여 money 가 0이 될 때까지 반복 ( 남은 금액에서 가장 큰 단위 순서로 조건문 실행 후 리스트 값 변경 )
        while (money > 0) {

            if (money >= 50000) {
                Integer 오만원 = answer.get(0);
                answer.set(0, ++오만원);
                money -= 50000;
            } else if (money >= 10000) {
                Integer 만원 = answer.get(1);
                answer.set(1, ++만원);
                money -= 10000;
            } else if (money >= 5000) {
                Integer 오천원 = answer.get(2);
                answer.set(2, ++오천원);
                money -= 5000;
            } else if (money >= 1000) {
                Integer 천원 = answer.get(3);
                answer.set(3, ++천원);
                money -= 10000;
            } else if (money >= 500) {
                Integer 오백원 = answer.get(4);
                answer.set(4, ++오백원);
                money -= 500;
            } else if (money >= 100) {
                Integer 백원 = answer.get(5);
                answer.set(5, ++백원);
                money -= 100;
            } else if (money >= 50) {
                Integer 오십원 = answer.get(6);
                answer.set(6, ++오십원);
                money -= 50;
            } else if (money >= 10) {
                Integer 십원 = answer.get(7);
                answer.set(7, ++십원);
                money -= 10;
            } else {
                Integer 일원 = answer.get(8);
                answer.set(8, ++일원);
                money -= 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int money = 50237;
        solution(money);
    }
}
