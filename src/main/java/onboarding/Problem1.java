package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     *예외처리 함수
     */
    private static int exception(List<Integer> person){
        if( person.get(0)%2==0 || person.get(1)%2==1){
            return -1;
        } else if (person.get(1) - person.get(0) != 1){
            return -1;
        } else{
            return 0;
        }
    }

}