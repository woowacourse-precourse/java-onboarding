package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkInput(pobi, crong))     // 예외사항 체크
            return -1;

        return answer;
    }

    public static int checkInput(List<Integer> pobi, List<Integer> crong){
        if (pobi[0] <= 1 || crong[1] >= 400)    // 페이지 범위 초과
            return 1;
        if (pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1])     // 같은 면의 페이지가 아님
            return 1;
        if (pobi[0] % 2 != 1 || crong[0] % 2 != 1)      // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아님
            return 1;
        return 0;
    }
}
