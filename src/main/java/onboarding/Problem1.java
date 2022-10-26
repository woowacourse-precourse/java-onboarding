package onboarding;

import java.util.List;

class Problem1 {
    //각 자리 수를 모두 합한 값을 반환
    public static int sum(int num){
        int ret = 0;
        int tmp = num;
        while(tmp != 0){
            ret += tmp % 10;
            tmp /= 10;
        }
        return ret;
    }
    //각 자리 수를 모두 곱한 값을 반환
    public static int mul(int num){
        int ret = 1;
        int tmp = num;
        while(tmp != 0){
            ret *= tmp % 10;
            tmp /= 10;
        }
        return ret;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //양면의 페이지 수 차가 1이 아니면 예외 발생
        if(Math.abs(pobi.get(0) - pobi.get(1)) != 1 || Math.abs(crong.get(0) - crong.get(1)) != 1) {
            return -1;
        }
        //시작 면이나 마지막 면이 나오면 예외 발생
        if(pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(0) == 399 || crong.get(0) == 399){
            return -1;
        }

        //왼쪽, 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함.
        int pScore = Math.max(
                Math.max(sum(pobi.get(0)), mul(pobi.get(0))),
                Math.max(sum(pobi.get(1)), mul(pobi.get(1)))
        );
        int cScore = Math.max(
                Math.max(sum(crong.get(0)), mul(crong.get(0))),
                Math.max(sum(crong.get(1)), mul(crong.get(1)))
        );

        if(pScore > cScore){
            answer = 1;
        }else if(cScore > pScore){
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;
    }
}