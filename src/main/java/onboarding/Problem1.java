package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*  포비나 크롱이 펼친 페이지들이 1만큼 차이나지 않으면 -1을 리턴 */
        boolean isValidPages = true;
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1)
            isValidPages = false;
        if(!isValidPages)
            return -1;

        return answer;
    }
}

/*
<<요구사항>>
1. 포비와 크롱이 펼친 페이지가 들어있는 배열이 주어진다.
2. 각자 왼쪽 페이지 번호의 각 자리 수를 모두 더하거나 모두 곱한 것 중 가장 큰 수를 취한다
3. 각자 오른쪽 페이지 번호의 각 자리 수를 모두 더하거나 모두 곱한 것 중 가장 큰 수를 취한다
4. 각자 2,3에서 구한 것 중 더 큰 수를 본인 점수로 한다
5. 포비가 더 크면 1, 크롱이 이기면 2, 무승부는 0, 예외사항은 -1을 리턴한다
 */

/*
<<기능 목록>>
- [V] 포비 또는 크롱의 왼쪽 페이지와 오른쪽 페이지가 1차이가 나지 않을 경우 -1을 리턴한다
- [] 포비와 크롱의 왼쪽 페이지 번호에 대해 각 자리 수를 모두 더하거나 모두 곱한 것 중 가장 큰 수를 구한다
- [] 포비와 크롱의 오른쪽 페이지 번호에 대해 각 자리 수를 모두 더하거나 모두 곱한 것 중 가장 큰 수를 구한다
- [] 포비와 크롱이 각자 왼쪽 오른쪽 페이지에 대해 구한 값 중 더 큰 값을 자신의 점수로 갖게 한다
- [] 포비와 크롱의 최종점수를 비교해 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0을 리턴한다.
 */