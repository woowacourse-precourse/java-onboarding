package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 화폐 및 동전 계산
    public static Integer isUnit(int number, int index){

        int unit = number;

        if(index % 2 == 0){ // 오만, 오천, 오백, 오십
            unit /= 5;
        }

        else if(index % 2 == 1){ // 만, 천, 백, 십
            if(unit == 10){ // 십 -> 일
                unit /= 10;
            }
            else {
                unit /= 2;
            }
        }

        return unit;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        // 각 화폐와 동전의 개수를 확인
        List<Integer> temp = new ArrayList<>();

        // 오만원부터 시작해서 십원까지 나누기 5, 나누기 2 반복
        int unit = 50000;

        // 인덱스 저장
        int i = 0;

        while (money!= 0){

            int count = money / unit;
            temp.add(i, count);

            money %= unit;

            unit = isUnit(unit, i);
            i++;

        }

        return answer;
    }
}