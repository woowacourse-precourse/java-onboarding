/**
 * 종류 총 9개
 * 돈을 오만, 만, 오천, 천, 오백, 백, 오십, 십, 일로 나눈 몫을 리스트에 각각 저장한다.
 * 큰 순서대로 나눈 몫을 저장한다.
 */

package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        create(answer);
        calculate(money, answer);

        return answer;
    }

    // 총 9가지의 돈 종류가 있으므로 요소 9개를 생성해주고 0으로 초기화한다.
    static List<Integer> create(List<Integer> list){
        for (int i = 0; i < 9; i++) {
            list.add(i, 0);
        }
        return list;
    }

    // 큰 순서대로 돈을 기준에 맞게 나누어 몫을 update해준다.
    // 돈을 조건에 맞게 계속 빼주고 돈이 0이 되면 반복문을 종료한다.
    static void calculate(int m, List<Integer> list){
        while(true){
            if(m == 0){
                break;
            }
            if(m >= 50000){
                int mok = m / 50000;
                list.set(0, mok);
                m -= mok * 50000;
            } else if(m >= 10000){
                int mok = m / 10000;
                list.set(1, mok);
                m -= mok * 10000;
            } else if(m >= 5000){
                int mok = m / 5000;
                list.set(2, mok);
                m -= mok * 5000;
            } else if(m >= 1000){
                int mok = m / 1000;
                list.set(3, mok);
                m -= mok * 1000;
            } else if(m >= 500){
                int mok = m / 500;
                list.set(4, mok);
                m -= mok * 500;
            } else if(m >= 100){
                int mok = m / 100;
                list.set(5, mok);
                m -= mok * 100;
            } else if(m >= 50){
                int mok = m / 50;
                list.set(6, mok);
                m -= mok * 50;
            } else if(m >= 10){
                int mok = m / 10;
                list.set(7, mok);
                m -= mok * 10;
            } else {
                int mok = m / 1;
                list.set(8, mok);
                m -= mok * 1;
            }
        }
    }
}
