package onboarding;

import java.util.List;

class Problem1 {
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

        return answer;
    }
}