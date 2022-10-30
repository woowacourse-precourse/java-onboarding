package onboarding;

import java.util.List;

/**
 * 기능 사항
 * 1.자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
 * 2.펼친 페이지 중 큰 값을 리턴하는 함수
 * 3.예외 사항 함수
 */
class Problem1 {
    /**
     * 1.자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
     */
    public static int cal(int n) {
        int sum = 0;
        int mul = 1;

        while(n > 0){
            sum += n%10;
            mul *= n%10;
            n/=10;
        }
        return Math.max(sum,mul);
    }

    /**
     * 2.펼친 페이지 중 큰 값을 리턴하는 함수
     */
    static int pageResult(List<Integer> list){
        return Math.max(cal(list.get(0)),cal(list.get(1)));
    }

    /**
     * 3.예외 사항 함수
     * 페이지가 번호가 순서대로 들어있지 않을 경우 true 리턴
     */
    public static boolean pageCheck(List<Integer> list){
        boolean errorCheck = false;
        if(list.get(0)+1 != list.get(1)) {
            errorCheck = true;
        }
        return errorCheck;
    }

    /**
     * 문제 해결을 위한 함수
     * 기능 요구 사항 결과 리턴
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pageCheck(pobi) || pageCheck(crong)){
            answer = -1;
            return answer;
        }
        if(pageResult(pobi)>pageResult(crong)){
            answer = 1;
        } else if (pageResult(pobi)<pageResult(crong)) {
            answer = 2;
        } else{
            answer = 0;
        }
        return answer;
    }

}