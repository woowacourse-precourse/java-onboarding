package onboarding;

import java.util.List;

/*
    기능 목록
    1. 가장 먼저 예외 케이스 발생을 고려
        -> 책을 임의로 펼쳤을때 왼쪽 페이지 1 or 오른쪽 페이지 400이 나올 경우 예외처리
        -> 왼쪽 페이지와 오른쪽 페이지가 1이상 차이나면 안되기 때문에 예외처리

    2. 왼쪽 페이지와 오른쪽 페이지 각각 더하는 함수, 곱하는 함수를 통해 최고 값을 선정
        -> Math 클래스의 max함수를 사용

    3. pobi와 crong의 최대 점수를 비교해 리턴 값 설정
        -> 삼항 연산자 사용
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}