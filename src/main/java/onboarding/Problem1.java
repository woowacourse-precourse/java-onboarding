package onboarding;

import java.util.List;

class Problem1 {
    int flag;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

//        flag = checkInput(pobi, crong);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    // 입력 값이 제대로 되어 있는지 확인하는 함수
    public static int checkInput(List<Integer> arr1, List<Integer> arr2) {

        // 입력 값이 연속된 수인지 확인. 연속된 수가 아니면 0반환
        if (arr1.get(0) != arr1.get(1) - 1) {
            return 0;
            // 입력 값이 1 또는 400을 포함하는 경우
        } else if (arr1.get(0) == 1 || arr2.get(0) == 1 || arr1.get(1) == 400 || arr2.get(1) == 400) {
            return 0;
        }
        // 입력 값이 연속된
        return 1;
    }



}