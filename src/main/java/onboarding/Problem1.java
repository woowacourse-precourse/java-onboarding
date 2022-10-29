package onboarding;

import java.util.List;

/*
========================================Problem1 기능 목록========================================
- 왼쪽 페이지가 홀수인지 판별하는 기능
- 오른쪽 페이지가 짝수인지 판별하는 기능
- 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 예외사항을 처리하는 기술
- 페이지의 각 자리 수를 더하는 기능
- 페이지의 각 자리 수를 곱하는 기능
- 두 개의 점수 중 가장 큰 점수를 정하는 기능
- 포비와 크롱의 점수를 비교해서 누가 이겼는지 알아내는 기능
 */

class Problem1 {

    public boolean isOdd(List<Integer> page){
        if((page.get(0) & 1) != 0)
            return true;
        else
            return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;



        return answer;
    }
}