package onboarding;

import java.util.List;

class Problem1 {
    /* 기능 구현
    1. 리스트로 받아 각각의 정수를 합하고 곱하는 함수
    2. 위의 합하고 곱한 결과물의 max값을 반환/누가 이겼는지 판단하기 (그 값을 가지는 사람이 win)
    -> pobi가 win : 1, crong이 win : 2
    3. 예외 상황(IllegalArgumentException + 페이지 범위) : 1, 400 페이지 펼침, -1 반환
    * */

    public static int solution(List<Integer> pobi, List<Integer> crong) {

    // 예외 사항 검사 함수
    private static void Validation(int page1, int page2) {
        if (page1 == 1 || page2 == 400 || (page1 + 1 != page2) || page1 % 2 == 0 || page2 % 2 == 1 ) {
            throw new IllegalArgumentException("page error");
        }
    }

    }
}

