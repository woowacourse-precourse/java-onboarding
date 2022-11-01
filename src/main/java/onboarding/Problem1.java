package onboarding;

import java.util.List;

/*
    1. 각 자리 숫자 구하기
    2. 각 자리 숫자 구한것에서 더하거나 곱한수 중 큰 수 구하기
    3. pobi와 crong의 점수 비교
    4. 시작면 마지막면 나오면 예외
    5. 페이지가 연속되지 않으면 예외
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiNum = maxNum(pobi);
        int crongNum = maxNum(crong);


        if(validity(pobi) == -1 || validity(crong) == -1) {
            answer = -1;
        }
        else if (pobiNum > crongNum) {
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int maxNum(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        int leftMax = Math.max(numSum(left), numMul(left));
        int rightMax = Math.max(numSum(right), numMul(right));

        return (leftMax > rightMax ? leftMax : rightMax);

    }

    public static int numSum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public static int numMul(int num) {
        int mul = 1;

        while (num != 0) {
            mul *= num % 10;
            num /= 10;
        }

        return mul;
    }

    public static int validity(List<Integer> list) {
        int pageContinuous = Math.abs(list.get(0) - list.get(1));

        return (pageContinuous != 1 ? -1 : 0);
    }


}