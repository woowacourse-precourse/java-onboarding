package onboarding;

import java.util.List;

/*
 * 곱하거나 더함
 *  포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1
 * */

// 기능 1 : 합과 곱 중 큰 수 찾아 큰 수 적용하기
// 기능 2 : 크롱과 포비의 점수 비교
// 기능 3 : 예외 처리(왼쪽 페이지 홀수 X, 오른쪽 페이지 짝수 X) / 시작 면이나 마지막 면 (1 ,400) 나온 경우 / 페이지 연속적이지 않은 경우
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 예외 처리
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != pobi.get(1)){
            return -1;
        } else if( pobi.get(0) % 2 == 0 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 ==0 || crong.get(1) %2 != 0 ){
            return -1;
        } else if(pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400){
            return -1;
        }

        //int pobiMax = Math.max();
        return answer;
    }

    public static int getMaxCal(int n) {
        int sum = 0;
        int mul = 0;
        while (n > 1) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }
        return Math.max(sum,mul);
    }

}