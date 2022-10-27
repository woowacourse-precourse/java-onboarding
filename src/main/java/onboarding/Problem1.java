package onboarding;

import java.util.List;
/*
# 예외상황 판단
1. 홀, 짝 으로 이루어져있는지 확인
2. 1, 400페이지 가 없는지 확인
3. 1차이가 나는지 확인
 */
/*
# 기능 구현
1. 예외상황 판단
2. pobi, crong 배열에[왼쪽더한것, 왼쪽곱한것, 오른쪽더한것, 오른쪽곱한것] / 배열 생성
3. 각각의 점수(max) 생성
4. 점수 비교
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (checkData(pobi) == false || checkData(crong) == false) {
            return -1;
        }

        return answer;
    }
    public static boolean checkData(List<Integer> list) { // 예외상황인지 확인하는 메서드
        int left = list.get(0);
        int right = list.get(1);
        if ((left % 2 == 0) || (right % 2 == 1)) { // 왼쪽에는 홀수가, 오른쪽에는 짝수가 와야한다.
            return false;
        }
        if (right - left != 1) { // 페이지의 차이는 1이어야만 한다
            return false;
        }
        if (left < 1 || left > 400 || right < 1 || right > 400) { // 페이지의 범위는 1~400이어야 한다
            return false;
        }
        return true;
    }
}