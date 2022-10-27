package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 예외 처리
     * 둘 중 하나라도 null 이면 false 반환
     * 1. list의 두 번째 인자가 첫 번째 인자보다 1만큼 큰 지 체크
     * 2. list의 1번째 값이 홀수인지 체크
     * 3. list의 값들이 지정된 범위를 넘지 않는지 체크 (3~398)
     * */
    static boolean check(List<Integer> list){
        if(list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400)
            throw new IllegalArgumentException("페이지의 범위를 벗어났습니다.");
        if(list.get(1)-list.get(0) != 1)
            throw new IllegalArgumentException("연속된 페이지를 입력하세요");
        if(list.get(0) % 2 != 1)
            throw new IllegalArgumentException("처음 페이지는 홀수입니다.");
        if(list.get(0) < 3 && list.get(0) > 397)
            throw new IllegalArgumentException("페이지 범위 밖입니다.");
        return true;
    }

}