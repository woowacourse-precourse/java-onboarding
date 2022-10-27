package onboarding;

import java.util.List;

class Problem1 {
    /*
    * 다음의 기능을 하는 메서드를 구현.
    * 1. 각 자리 숫자를 더하는 메서드 sumValue
    * 2. 각 자리 숫자를 곱하는 메서드 mulValue
    * 3. 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자를 더하고 곱하고 비교하여 가장 큰수를 리턴하는 메서드 getMaxValue
    * 4. 점수를 비교하여 승자를 정하는 메서드 whoIsWinner
    * */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    // 각 자리 숫자를 더하는 메서드
    int sumValue(int value) {
        int res = (value % 10) + (value % 100 / 10) + (value / 100);
        return res;
    }
    // 각 자리 숫자를 곱하는 메서드
    int mulValue(int value) {
        int res = (value % 10) * (value % 100 / 10) + (value / 100);
        return res;
    }

    // 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자를 더하고 곱하여 더 큰 숫자를 반환하는 메서드
    int getMaxValue(int leftValue, int rightValue) {
        int leftMax = Math.max(sumValue(leftValue), mulValue(leftValue));
        int rightMax = Math.max(sumValue(rightValue), mulValue(rightValue));
        int max = Math.max(leftMax, rightMax);
        return max;
    }

    // 점수를 비교하여 승자를 정하는 메서드 whoIsWinner
    int whoIsWinner(List<Integer> gamer1, List<Integer> gamer2) {
        int answer = -1;
        int gamer1Point = getMaxValue(gamer1.get(0), gamer1.get(1));
        int gamer2Point = getMaxValue(gamer2.get(0), gamer2.get(1));
        if(gamer1Point > gamer2Point) {
            answer = 1;
        } else if (gamer1Point < gamer2Point) {
            answer = 2;
        } else if (gamer1Point == gamer2Point) {
            answer = 0;
        }
        return answer;
    }

}