package onboarding;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isWrongInput(pobi, crong)) {
            return EXCEPTION;
        }

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        answer = getAnswer(pobiMax, crongMax);
        return answer;
    }

    // 최종 결과 구하기
    private static int getAnswer(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) return POBI_WIN;
        if (pobiMax < crongMax) return CRONG_WIN;
        return DRAW;
    }

    // 왼쪽 페이지, 오른쪽 페이지 중 최댓값 반환
    public static int getMax(List<Integer> person) {
        String left = String.valueOf(person.get(0));
        String right = String.valueOf(person.get(1));
        int max = Math.max(getLargeSumMul(left), getLargeSumMul(right));

        return max;
    }

    // 해당 페이지에서 각 자리수 합 or 곱 중 큰값 반환
    public static int getLargeSumMul(String page) {
        int sum = 0, mul = 1;

        for (int i = 0; i < page.length(); i++) {
            int n = page.charAt(i) - '0';
            sum += n;
            mul *= n;
        }

        return Math.max(sum, mul);
    }

    // 입력된 페이지들이 조건에 맞는지 확인
    public static boolean isWrongInput(List<Integer> pobi, List<Integer> crong) {
        return (isFirstOrLast(pobi, crong) || isNotConsecutive(pobi, crong));
    }

    // 연속된 페이지가 아닌경우
    public static boolean isNotConsecutive(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1));
    }

    // 시작면 or 마지막면이 나오는 경우
    public static boolean isFirstOrLast(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400);
    }
}