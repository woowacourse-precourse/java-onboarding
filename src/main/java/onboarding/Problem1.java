package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkInvalidInput(pobi) || checkInvalidInput(crong))
            return -1;
        return answer;
    }

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