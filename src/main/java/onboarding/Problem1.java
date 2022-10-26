package onboarding;

import java.util.List;

// <기능 목록>
// 1. 예외상황인지 각각 판별 (해당되면 return -1)
// 결과 예외상황: 왼쪽페이지!=홀수, 오른쪽페이지!=짝수, 오른쪽페이지-왼쪽페이지!=1
// 2. 각각의 max num을 구함
// 3. 점수 비교

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 1. 예외상황인지 각각 판별
        if(isExcption(pobi.get(0),pobi.get(1))){
            return -1;
        }
        if(isExcption(crong.get(0),crong.get(1))){
            return -1;
        }

        return answer;
    }

    // 예외상황 판별
    public static boolean isExcption(int left, int right) {
        if (left % 2 != 1) {
            return true;
        }
        if (right % 2 != 0) {
            return true;
        }
        if(right-left !=1){
            return true;
        }
        return false;
    }
}