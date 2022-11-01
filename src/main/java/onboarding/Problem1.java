package onboarding;

import java.util.List;

/*
1. 페이지가 잘못된 경우(홀,짝 순서가 아님/ 1이상 차이남) -1 return
2. 잘 된 경우
    a. 포비의 경우
        가. 1의 자리부터 한 자리씩 올려가며 모든 자리를 곱하거나, 더함
        나. 이전 최대, 모든 자리 곱한 값, 모든 자리 더한 값 중 최대값을 포비의 최대값에 저장
        다. 왼쪽, 오른쪽 두 번 반복, 두번 중 최대값이 포비의 최대값에 저장됨
    b. 크롱의 경우
        가. a 반복
    c. 포비와 크롱의 최대값 중 포비가 크면 1, 크롱이 크면 2 return
*/
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}