package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static boolean validation(List<Integer> list) {
        if (1 > list.get(0) || 400 < list.get(0)) {
            return true;
        }
        if (1 > list.get(1) || 400 < list.get(1)) {
            return true;
        }
        return list.get(0) + 1 != list.get(1);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. page 정상인지 확인 후 비정상일 경우 -1 return
        int answer = Integer.MAX_VALUE;
        if (validation(pobi) || validation(crong)) {
            return -1;
        }
        // 2. 숫자 하나씩 분해
        // 3. pobi 와 crong 의 최대값 구하기
        // 4. 승부에 따라 0,1,2 return

        return answer;
    }
}
