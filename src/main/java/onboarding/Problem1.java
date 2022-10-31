package onboarding;

import java.util.List;

//------기능------
//0. 오류 검출
//1. 곱하기
//2. 더하기
//3. 곱하기 더하기 중 더 큰 수 구하기
//3. max

class Problem1 {
    private static int addNum(int pageNum) {
        int num = 0;

        while (pageNum > 0)
        {
            num += pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private static int mulNum(int pageNum) {
        int num = 1;

        while (pageNum > 0)
        {
            num *= pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private static int pickNum(int pageNum) {
        return Math.max(addNum(pageNum), mulNum(pageNum));
    }

    private static boolean isExp(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0)
            return true;

        if (pobi.get(0) != pobi.get(1) - 1 || crong.get(0) != crong.get(1) - 1)
            return true;

        if (pobi.get(0) <= 1 || pobi.get(0) >= 400
                || pobi.get(1) <= 1 || pobi.get(1) >= 400 ||
                crong.get(0) <= 1 || crong.get(0) >= 400 ||
                crong.get(1) <= 1 || crong.get(1) >= 400)
            return true;
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiNum, crongNum;

        if (isExp(pobi, crong))
            return -1;

        pobiNum = Math.max(pickNum(pobi.get(0)), pickNum(pobi.get(1)));
        crongNum = Math.max(pickNum(crong.get(0)), pickNum(crong.get(1)));

        if (pobiNum == crongNum)
            return 0;
        return pobiNum > crongNum ? 1 : 2;
    }
}