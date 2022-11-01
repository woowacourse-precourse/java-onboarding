package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        // 1~10000 의 범위를 벗어나는지 체크
        if(number < 1 || number > 10000) return -1;
        int count = 0;
        // 각 숫자를 돌면서 369의 개수를 체크 후 count에 합한다.
        for (int i = 1; i <= number; i++) {
            count += get369Count(i);
        }
        return count;
    }

    // 정수를 넣으면 해당 정수의 3,6,9의 개수를 반환하는 함수
    static int get369Count(int number) {
        List<Integer> newList = new ArrayList<Integer>();
        int count = 0;
        // 정수의 각 자리수를 newList에 저장
        while (number > 0) {
            newList.add(number % 10);
            number /= 10;
        }
        // 각 자리수를 돌며 3,6,9에 해당하는 수가 있으면 count 증가
        for (int i : newList) {
            if(i % 3 == 0 && i != 0) count++;
        }
        return count;
    }
}