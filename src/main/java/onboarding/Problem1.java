package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if ((pobi.get(1) != pobi.get(0) + 1) || (crong.get(1) != crong.get(0) + 1)) {
            return -1;
        }

        final int finalPobiNum = bigOne(addNum(pobi.get(0)), muxNum(pobi.get(0)), addNum(pobi.get(1)), muxNum(pobi.get(1)));
        final int finalCrongNum = bigOne(addNum(crong.get(0)), muxNum(crong.get(0)), addNum(crong.get(1)), muxNum(crong.get(1)));

        if (finalPobiNum > finalCrongNum) return 1;
        else if (finalPobiNum < finalCrongNum) return 2;
        else return 0;

    }

    private static int addNum(int pageNum) {
        return (pageNum / 100) + (pageNum % 100 / 10) + (pageNum % 100 % 10);
    }

    private static int muxNum(int pageNum) {
        if (pageNum >= 100) {
            return (pageNum / 100) * (pageNum % 100 / 10) * (pageNum % 100 % 10);
        } else if (pageNum >= 10) {
            return (pageNum / 10) * (pageNum % 10);
        } else return pageNum;
    }

    private static int bigOne(int leftAddNum, int leftMuxNum, int rightAddNum, int rightMuxNum) {
        return Math.max(Math.max(leftAddNum, leftMuxNum), Math.max(rightAddNum, rightMuxNum));
    }
}
