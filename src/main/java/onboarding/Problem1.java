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
        try {
            int pobiPoint = getMaxPoint(pobi);
            int crongPoint = getMaxPoint(crong);

            // 누가 이겼는지 판단
            if (pobiPoint > crongPoint){
                return 1;
            }
            if (pobiPoint < crongPoint){
                return 2;
            }
            else{
                return 0;
            }
            // 예외상황
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    // 예외 사항 검사 함수
    private static void Validation(int page1, int page2) {
        if (page1 == 1 || page2 == 400 || (page1 + 1 != page2) || page1 % 2 == 0 || page2 % 2 == 1 ) {
            throw new IllegalArgumentException("page error");
        }
    }
    public static int getMaxPoint(List<Integer> pages) {
        int page1 = pages.get(0);
        int page2 = pages.get(1);

        // 먼저 유효성 검사를 한 후,
        Validation(page1, page2);

        // pobi, crong 각자의 합, 곱의 최댓값 반환
        int leftMax = Math.max(getPlus(page1), getMultiple(page1));
        int rightMax = Math.max(getPlus(page2), getMultiple(page2));
        return Math.max(leftMax, rightMax);
    }


    // 숫자는 index별 계산이 안되기 때문에 string으로 변환 후, 계산 시 c - '0'로 int형 변환을 해주었습니다.
    public static int getPlus(int p) {
        int plus = 0;
        String s = Integer.toString(p);
        for (char c : s.toCharArray()) {
            plus += c - '0';
        }
        return plus;
    }

    public static int getMultiple(int p) {
        int mul = 1;
        String s = Integer.toString(p);
        for (char c : s.toCharArray()) {
            mul *= c - '0';
        }
        return mul;


    }
}

