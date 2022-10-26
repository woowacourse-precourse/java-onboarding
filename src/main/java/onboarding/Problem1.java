package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하는 기능을 하는 함수
    public static int getSumPageNum(Integer pageNum){
        int sum = 0;
        while (pageNum > 0) {
            sum += pageNum % 10;
            pageNum /= 10;
        }
        return sum;
    }

}