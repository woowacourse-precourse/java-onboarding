package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 오른쪽 페이지의 번호는 언제나 왼쪽 페이지의 번호보다 1만큼 크다.
        // 따라서 그런 경우가 아니라면 -1을 반환한다.
        if (pobi.get(0) + 1 != pobi.get(1)) return -1;
        if (crong.get(0) + 1 != crong.get(1)) return -1;

        // 왼쪽 페이지는 홀수고 오른쪽 페이지는 짝수여야 한다.
        // 그런 경우가 아니라면 -1을 반환한다.
        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1) return -1;
        if (crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1) return -1;



        return answer;
    }
}