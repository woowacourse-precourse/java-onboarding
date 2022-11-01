package onboarding;

import java.util.List;

class Problem1 {
    // 기능#4 (기능#1과 기능#3을 실행하여) 상황에 맞는 결과값을 반환
    // 예외상황 -1, 무승부 0, 포비 승리 1, 크롱 승리 2 반환
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkInvalidInput(pobi) || checkInvalidInput(crong))
            return -1;
        int result = calculatePlayerScore(pobi) - calculatePlayerScore(crong);

        if(result == 0)
            return 0;
        return result > 0? 1: 2;
    }

    // 기능#3 주어지는 List의 left, right에 대해 2번을 실행하고, 더 큰 수를 반환
    public static int calculatePlayerScore(List<Integer> player) {
        int leftResult = calculatePageScore(player.get(0));
        int rightResult = calculatePageScore(player.get(1));
        return leftResult > rightResult? leftResult: rightResult;
    }

    // 기능#2 주어진 정수의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 반환
    static int calculatePageScore(int pageNumber) {
        int multiple = 1;
        int summation = 0;
        while(pageNumber != 0) {
            int placeValue = pageNumber % 10;
            multiple *= placeValue;
            summation += placeValue;
            pageNumber /= 10;
        }
        return multiple > summation? multiple: summation;
    }

    // 기능#1 입력값이 유효하지 않은 입력인지 확인
    // 유효하지 않으면 false, 유효하면 true 반환
    static boolean checkInvalidInput(List<Integer> list) {
        int left = list.get(0), right = list.get(1);

        // 예외처리 #3 페이지 번호가 1 미만의 값을 갖는 경우
        // 예외처리 #4 페이지 번호가 400 초과의 값을 갖는 경우
        if(left < 1 || 400 < left || right < 1 || 400 < right)
            return true;

        // 예외처리 #1 왼쪽 페이지 번호가 홀수가 아닌 경우
        // 예외처리 #2 오른쪽 페이지 번호가 짝수가 아닌 경우
        // 예외처리 #5 왼쪽 페이지 번호와 오른쪽 페이지 번호가 연속적이지 않은 경우
        // 예외처리 #6 왼쪽 페이지 번호가 오른쪽 페이지 번호 보다 큰 경우
        if(left % 2 == 0 || left + 1 != right)
            return true;

        // 예외처리 #7 주어진 페이지 번호가 시작 면을 의미하는 경우
        if(left == 1 && right == 2)
            return true;

        // 예외처리 #8 주어진 페이지 번호가 마지막 면을 의미하는 경우
        if(left == 399 && right == 400)
            return true;

        return false;
    }
}