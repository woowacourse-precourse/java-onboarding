package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        // ExceptionCheck
        if(isExceptionCase(pobi) || isExceptionCase(crong)) {
            answer = -1;
            return answer;
        }

        // MaxNumber Comparison
        if(pobiMax > crongMax) {
            answer = 1;
        } else if(pobiMax == crongMax) {
            answer = 0;
        } else {
            answer = 2;
        }

        return answer;
    }

    public static int calculateMax(Integer num) {
        int addNum = 0;
        int mulNum = 1;
        while(num > 0) {
            int tmp = num % 10;

            addNum += tmp;
            mulNum *= tmp;

            num /= 10;
        }
        return Math.max(addNum, mulNum);
    }
    public static int getMax(List<Integer> user) {
        int leftMax, rightMax;

        // 왼쪽 페이지 최대 계산
        leftMax = calculateMax(user.get(0));

        // 오른쪽 페이지 최대 계산
        rightMax = calculateMax(user.get(1));

        return Math.max(leftMax, rightMax);
    }

    public static boolean isExceptionCase(List<Integer> user) {

        // 1. 페이지 번호가 1 ~ 400이 아닌 경우
        if(user.get(0) < 1 || user.get(0) > 400 || user.get(1) < 1 || user.get(1) > 400) {
            return true;
        }

        // 2. 왼쪽 페이지가 홀수가 아닌 경우
        if(user.get(0) % 2 != 1) {
            return true;
        }

        // 3. 오른쪽 페이지가 짝수가 아닌 경우
        if(user.get(1) % 2 != 0) {
            return true;
        }

        // 4. 왼쪽 페이지 + 1 != 오른쪽 페이지인 경우
        if(user.get(0) + 1 != user.get(1)) {
            return true;
        }

        return false;
    }
}