package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isLeftOdd(pobi, crong) || !isSuccessive(pobi, crong) || isOutOfRange(pobi, crong)) {
            return -1;
        }
        return whoWin(getMaxValue(pobi), getMaxValue(crong));
    }

    private static boolean isLeftOdd(List<Integer> pobi, List<Integer> crong) { // 왼쪽 값이 홀수인가 ?
        return (pobi.get(0) % 2 == 1) && (crong.get(0) % 2 == 1); // 참이면 조건 만족
    }

    private static boolean isSuccessive(List<Integer> pobi, List<Integer> crong) { // 연속적이지 않음
        return (pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1)); // 참이면 조건 만족
    }

    private static boolean isOutOfRange(List<Integer> pobi, List<Integer> crong) { // 1~400 을 벗어남
        return pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400; // 거짓이면 조건 만족
    }

    private static int getMaxValue(List<Integer> values) { // 한 사람의 가장 큰 값 구하기
        int leftValue = values.get(0);
        int rightValue = values.get(1);

        return Math.max(getMaxHabOrGob(leftValue), getMaxHabOrGob(rightValue));
    }

    private static int getMaxHabOrGob(int x) { // 두 수 각각의 합과 곱중 최대값 구하기
        int hab = 0;
        int gob = 1;

        while (x != 0) {
            hab += (x % 10);
            gob *= (x % 10);
            x = x / 10;
        }

        return Math.max(hab, gob);
    }

    private static int whoWin(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }
}