package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        if (pobiScore == -1 || crongScore == -1) {
            return -1;
        }
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    static int getScore(List<Integer> inputList) {
        if (inputList.size() != 2) {
            return -1;
        }
        int leftPageNum = inputList.get(0);
        int rightPageNum = inputList.get(1);
        if (rightPageNum - leftPageNum != 1 || !isOdd(leftPageNum) || !isEven(rightPageNum)) {
            return -1;
        }
        int addRet = Math.max(addResult(leftPageNum), addResult(rightPageNum));
        int mulRet = Math.max(multiplyResult(leftPageNum), multiplyResult(rightPageNum));
        return Math.max(addRet, mulRet);
    }

    // 각 자리수 덧셈 결과
    static int addResult(int x) {
        int ret = 0;
        while (x > 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }

    // 각 자리수 곱셈 결과
    static int multiplyResult(int x) {
        int ret = 1;
        while (x > 0) {
            ret *= x % 10;
            x /= 10;
        }
        return ret;
    }

    static boolean isOdd(int x) {
        if (x % 2 == 1) {
            return true;
        }
        return false;
    }

    static boolean isEven(int x) {
        if (isOdd(x)) {
            return false;
        }
        return true;
    }
}