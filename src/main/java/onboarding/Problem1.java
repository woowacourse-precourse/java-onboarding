package onboarding;

import java.util.List;

// 기능목록
// 1. 예외처리
// 2. 자리수의 합과 곱 중 최댓값 구하기
// 3. 크롱과 포비의 최댓값 비교하기
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //예외처리
        //왼쪽 페이지가 홀수가 아니면 리턴
        if(pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0){
            return  -1;
        //오른쪽 페이지가 이상하면 리턴
        } else if (pobi.get(1) != pobi.get(0) + 1 || crong.get(1) != crong.get(0) + 1) {
            return  -1;
        //시작면이나 마지막 면이 나오면 리턴
        } else if(pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400){
            return  -1;
        }
        return answer;
    }

}