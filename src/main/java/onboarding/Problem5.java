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

        return answer;
    }
}