package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean validValuePobi = isValid(pobi);
        boolean validValueCrong = isValid(crong);

        if(!(validValuePobi && validValueCrong)) {
            return -1;
        }

        return 0;
    }

    /*
    예외사항 확인
    배열 값의 크기는 1 차이가 나야 유효한 값으로 인정한다.
    */
    static private boolean isValid(List<Integer> testingArr) {

        if (Math.abs(testingArr.get(0) - testingArr.get(1)) != 1) {
            return false;
        }
        else {
            return true;
        }

    }

/*
    int answer = Integer.MAX_VALUE;
    return answer;
 */

}