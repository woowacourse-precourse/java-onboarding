package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int maxValue(List<Integer> pageArray) {
        List<Integer> values = new ArrayList<>();

        // 왼쪽, 오른쪽 페이지 각자리의 곱
        for(int i = 0; i < 2; i++) {
            if(pageArray.get(i) / 100 != 0) { // 페이지가 100 ~ 400인 경우
                values.add(i, (pageArray.get(i) / 100) * (pageArray.get(i) % 100 / 10) * (pageArray.get(i) % 10));
            }
            else if(pageArray.get(i) / 10 != 0) { // 페이지가 10 ~ 99인 경우
                values.add(i, (pageArray.get(i) / 10) * (pageArray.get(i) % 10));
            }
            else { // 페이지가 1 ~ 9인 경우
                values.add(i, pageArray.get(i));
            }
        }

        // 왼쪽 페이지 각 자리수 합
        values.add(2, (pageArray.get(0) / 100) + (pageArray.get(0) % 100 / 10) + (pageArray.get(0) % 10));
        // 오른쪽 페이지 각 자리수 합
        values.add(3, (pageArray.get(1) / 100) + (pageArray.get(1) % 100 / 10) + (pageArray.get(1) % 10));

        // 4가지 값이 들어있는 배열 values 오름차순으로 정렬
        Collections.sort(values);

        return values.get(3);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}