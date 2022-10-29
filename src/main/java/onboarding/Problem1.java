package onboarding;

import java.util.List;

class Problem1 {

    //입력 조건을 검사하는 method
    public static boolean verifyConditions(List<Integer> test){
        boolean metConditions = true;
        if(!(test.get(0) >=1 & test.get(0) <=400))
            metConditions = false;
        else if((test.get(0)%2 != 1) | (test.get(1)%2 !=0))
            metConditions = false;
        return metConditions;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //입력 조건 만족하지 않을 경우 예외사항 return
        if(!verifyConditions(pobi))
            return -1

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}